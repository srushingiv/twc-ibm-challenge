package org.srushingiv.twc

object Main extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "Run this app with `sbt test` instead."
}
