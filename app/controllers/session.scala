package controllers
import play.api.mvc._

class session extends Controller{
  def store = Action { request =>


    Ok("Hello World!").withSession(
      request.session + ("saidHello" -> "scala"))
  }


  def index = Action { request =>
    request.session.get("saidHello").map { user =>
      Ok("Hello " + user)
    }.getOrElse {
      Unauthorized("Oops, you are not connected")
    }
  }
  def disca= Action { request =>
  Ok("bye").withNewSession
  }

}
