package services

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, Uri}
import akka.http.scaladsl.unmarshalling.Unmarshal

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

trait ProblemInfo {
  val id: Int
  val title: String

  def description(): String = {
    implicit val actorSystem = ActorSystem()
    implicit val ec = scala.concurrent.ExecutionContext.Implicits.global

    val responseFuture = Http().singleRequest(HttpRequest(HttpMethods.GET
      , uri = Uri(s"https://projecteuler.net/minimal=${id}")
    ))

    Await.ready(responseFuture, Duration.Inf)

    responseFuture.value.get match {
      case Success(response) =>
        Await.result(Unmarshal(response.entity).to[String], Duration.Inf)
      case Failure(error) =>
        error.getMessage
    }
  }
}
