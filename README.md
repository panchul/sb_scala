
# sb_scala

Scala sandbox for variety of templates, and tutorial snippets.

This repository could be a useful starting point for writing Scala code, or demoing how to do it.
It could be used on its own, or deployed on a virtual machine within the workspace [https://github.com/panchul/workspace](https://github.com/panchul/workspace)

The ```/doc``` folder of the ```workspace``` repo has the documentation. 

I will gradually migrate the notes I have to this repository. To keep track of what I am adding:

+ knapsack
    - Implementation of a knapsack problem, for Forge Of Empires quest, to achieve exact population size.
      There is a quick one-file script as well, in ```snippets``` folder. This is an ```sbt``` template with
      Scalatest, etc.

+ snippets
    - Quick refresher on Scala. Just to trigger the Scala mindset if I did not use it in a while.

+ uuid_producer_consumer
    - Demoes how to create actors to produce/consume tokens.
      (To run, install ```sbt``` and run ```sbt reload clean compile run``` in that folder)
     
+ scala-play-kafka
    - Simple REST API in Play framework, combination of examples from internet. Uses [https://github.com/panchul/workspace](https://github.com/panchul/workspace)
      (initially got it from [https://github.com/Interrupt/scala-play-kafka-example](https://github.com/Interrupt/scala-play-kafka-example))

+ akka-camel-kafka
    - Simple Camel/Kafka/Akka combination of examples from internet. Uses [https://github.com/panchul/workspace](https://github.com/panchul/workspace)
      (initially got it from [https://github.com/Interrupt/akka-camel-kafka-example](https://github.com/Interrupt/akka-camel-kafka-example))

+ rest_shorty
    - ﻿RESTful url shortening application written in Scala.
      (from [https://github.com/davetron5000/shorty](https://github.com/davetron5000/shorty) )


TODO: add a clean example from here: [https://github.com/elodina/scala-kafka](https://github.com/elodina/scala-kafka) 
      (seem to be doing things similar to my way, with virtual machines)
      
      
      