package controllers

import play.api.libs.json.Json
import play.api.mvc._

class Application extends Controller {
  implicit val myCustomCharset = Codec.javaSupported("iso-8859-1")

  def index = Action {
    Ok(Json.prettyPrint(Json.obj("name" -> "Srinu",
    "age" -> 35)))
  }
}
