package controllers
import play.api.mvc._
/**
  * Created by shiva on 29/11/16.
  */
//val x = 89
class Flash extends Controller{
  val x = 89

  def save = Action {
    Redirect("/venky").flashing(
      "success" -> "The item has been created")
  }
  def index = Action { implicit request =>
    Ok {
      request.flash.get("success").getOrElse("Welcome!")
    }
  }




}
