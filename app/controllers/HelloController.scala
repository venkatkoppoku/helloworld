package controllers

import play.api.mvc.{ Action, Controller }

class HelloController extends Controller {
  def hello = Action { request =>
    Ok("HELLO, VENKY!")
  }
  def helloTo(name: String) = Action { request =>
    Ok(s"Hello, $name!")

  }
  def show (id:String) = Action { request =>
  Ok(s"Id is: $id")}
}