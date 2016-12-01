package controllers
import play.api.mvc._
import play.api.libs.json._
/**
  * Created by shiva on 30/11/16.
  */
class SecondJson extends Controller {
  def index = Action { request =>
  Ok(Json.obj("name" -> "venky",
              "age"   -> 23.0,
              "likes" -> Json.arr( "scala",
                                    "programming",
                                    "language"),


               "dislikes"  -> JsNull  ))
  }

}
