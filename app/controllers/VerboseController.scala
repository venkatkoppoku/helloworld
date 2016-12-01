package controllers

import play.api.mvc.{Action,Controller}


class VerboseController extends Controller {
  def say(msg:String,n:Int) = Action { request =>
   Ok(List.fill(n)(msg) mkString "\n"  )
  }
}
