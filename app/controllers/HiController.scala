package controllers
import play.api.mvc.{ Action, Controller }

/**
  * Created by shiva on 26/11/16.
  */
class HiController extends Controller
{
  def hi = Action { request =>
  Ok(" hi,venky")
  }

  def hiTO(name:String) = Action { request =>
  Ok(s" hi $name")
  }

  def index(name: String) = TODO
}
