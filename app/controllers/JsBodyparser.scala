package controllers
import play.api.mvc._
import play.api.libs.json._
/**
  * Created by shiva on 30/11/16.
  */
class JsBodyparser extends Controller{
  def index = Action { request =>
    Ok(
    Json.parse("""{ "name": "Dave", "age": 35 }""") )

  }

}
