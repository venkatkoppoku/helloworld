package controllers
import play.api.libs.json._
import play.api.mvc._


/**
  * Created by shiva on 30/11/16.
  */
class firstJson  extends Controller{
  def index = Action { request =>
   Ok( JsObject(Seq(

     "name" -> JsString("Dave"),

     "age" -> JsNumber(35.0),

     "likes" -> JsArray(Seq(

       JsString("Scala"),

       JsString("Coffee"),

       JsString("Pianos")

     )),


     "dislikes" -> JsNull
   ))
   )





  }




  }
