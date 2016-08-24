/**
  * Created by apanchul on 6/9/16.
  */

import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.UUID

import scala.actors._
import scala.actors.Actor._
import scala.collection.mutable.Queue

object UniqueIdGenerator{
  val uuids  = new Queue[UUID] //new LinkedBlockingQueue[UUID]()

  populate();

  def getId: UUID = {
    //val id = uuids.take()
    val id = uuids.dequeue
    //repoulate if empty
    if(uuids.size==0){
      populate()
    }
    return id
  }

  def populate() = {
    println("populating...")
    for( i <- 1 to 1000){
      //uuids.put(UUID.randomUUID())//
      uuids.enqueue(UUID.randomUUID())
    }
  }
}

object UniqueIdGeneratorActor extends Actor{

  def act(){
    var consumerDone=0
    loop {
      react{
        case (requester:Actor) =>
          requester !  UniqueIdGenerator.getId
        case "ConsumerDone" =>
          consumerDone = consumerDone+1
          if(consumerDone==100){
            println("I am done too")
            exit()
          }
      }
    }
  }
}

class IdConsumer(name:String) extends Actor{
  def act(){
    var i=0
    println(name + " started")
    UniqueIdGeneratorActor ! (self)
    loop {
      react{
        case "EXIT" =>
          UniqueIdGeneratorActor ! "ConsumerDone"
          println(name + " was shutdown")
          exit()

        case msg =>
          i=i+1
          if(i==1000){
            UniqueIdGeneratorActor ! "ConsumerDone"
            println(name + " is done")
            exit()
          }else{
            if(i % 100 == 0) {
              println("TRACE: " + name + " got message number " + i)
            }
              
            UniqueIdGeneratorActor ! (self)
          }
      }

    }
  }
}

object myappclass extends App {
  
  println("Starting UUID generation demo.")
  UniqueIdGeneratorActor.start()
  for(i <- 1 to 100){
    val consumer = new IdConsumer("consumer" + i)
    consumer.start()
  } 
  
}
