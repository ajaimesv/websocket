package controllers

import actors.WebSocketActor
import akka.actor.ActorSystem
import akka.stream.Materializer

import javax.inject._
import play.api.libs.streams.ActorFlow
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents)
                              (implicit system: ActorSystem, mat: Materializer) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def ws: WebSocket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      WebSocketActor.props(out)
    }
  }

}
