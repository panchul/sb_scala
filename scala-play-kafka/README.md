
# Simple REST API in Play

(The initial version was from [https://github.com/Interrupt/scala-play-kafka-example](https://github.com/Interrupt/scala-play-kafka-example) )

An activator [template](https://typesafe.com/activator/templates) for implementing Json based [REST API](https://www.playframework.com/documentation/2.3.x/ScalaJsonHttp).


Here is what you can do:

    $ sbt run
    $ curl localhost:9000

It will give you the page

    $ curl localhost:9000/books
    [{"name":"TAOCP","author":"Knuth"},{"name":"SICP","author":"Sussman, Abelson"}]

To add a book:

    $ curl -H "Content-Type: application/json" -X POST -d '{"name":"test title","author":"test aurhtor"}' xidev1:9000/books
   ﻿{"status":"OK"}

The trace of the activity is in log/application.log 
     
    