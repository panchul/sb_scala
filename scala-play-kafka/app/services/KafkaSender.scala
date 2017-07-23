package services

import akka.actor.{Props, Actor}
import play.Logger

object KafkaSender {
  def props(topic: String): Props = Props(new KafkaSender(topic))
}

class KafkaSender(topic: String) extends Actor {
  // broker is running by default on host 9092
  //val producer = new KafkaProducer(topic,"localhost:9092")
  val producer = new KafkaProducer(topic,"kafka-broker1.vm:9092")
  Logger.info(s"[TRACE] Created producer {${producer.toString}}")
  
  def receive = {
    case message: String => {
      try {
        Logger.info(s"[TRACE] About to run producer.send on message {$message}")
        producer.send(message)
      }
      catch {
        case e: Exception => Logger.error("Could not send message.", e)
      }
    }
  }
}
