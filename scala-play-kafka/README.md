
# Simple REST API in Play

(The initial version was from [https://github.com/Interrupt/scala-play-kafka-example](https://github.com/Interrupt/scala-play-kafka-example) )

An activator [template](https://typesafe.com/activator/templates) for implementing Json based [REST API](https://www.playframework.com/documentation/2.3.x/ScalaJsonHttp).


Here is what you can do:

Start the Zookeeper and Kafka clusters. The sample is hardcoded to send data to
zookeeper[1,2].vm and kafka-broker1.vm - they are all available in workspace VMs.

To see what is being sent to Kafka, for example, open a kafka-console-consumer:

    $ kafka-console-consumer.sh --zookeeper zookeeper1.vm:2181,zookeeper2.vm:2181 --topic myevents

Start the server:

    $ sbt run
    $ curl localhost:9000

It will give you the page

    $ curl localhost:9000/books
    [{"name":"TAOCP","author":"Knuth"},{"name":"SICP","author":"Sussman, Abelson"}]

To add a book:

    $ curl -H "Content-Type: application/json" -X POST -d '{"name":"test title","author":"test aurhtor"}' xidev1:9000/books
   ﻿{"status":"OK"}

The trace of the activity is in log/application.log 
     

## To ran as a stand-alone package:

    $ sbt dist
    ...
    [info] Done packaging.
    [info] 
    [info] Your package is ready in .../scala-play-kafka/target/universal/simple-rest-scala-1.0-SNAPSHOT.zip
    [info] 
    [success] Total time: 14 s, completed Dec 5, 2018 7:00:17 PM
    
    $ cp .../scala-play-kafka/target/universal/simple-rest-scala-1.0-SNAPSHOT.zip /tmp/something/
    $ cd tmp/something
    $ unzip .../scala-play-kafka/target/universal/simple-rest-scala-1.0-SNAPSHOT.zip
    
    $ simple-rest-scala-1.0-SNAPSHOT/bin/simple-rest-scala
    Play server process ID is 7307
    SLF4J: Class path contains multiple SLF4J bindings.
    [info] play - Application started (Prod)
    [info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
    ...
        