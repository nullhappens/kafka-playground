package com.nullhappens.kafka

import cats.effect._
import cats.effect.Console.implicits._

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    Console[IO].putStrLn("it works").as(ExitCode.Success)

}
