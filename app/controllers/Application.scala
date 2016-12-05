package controllers



import play.api.libs.json. Json
import play.api.mvc._

class Application extends Controller {


  def index = Action {
    Ok(Json.prettyPrint(Json.parse("""
{
  "name" : "Watership Down",
  "location" : {
    "lat" : 51.235685,
    "long" : -1.309197
  },
  "residents" : [ {
    "name" : "Fiver",
    "age" : 4,
    "role" : null
  }, {
    "name" : "Bigwig",
    "age" : 6,
    "role" : "Owsla"
  } ]
}
                                   """)
    )
    )

  }

  def indx = Action { request =>
    Ok(Json.toJson(Seq(1, 2, 3, 4)))
  }

  def ind = Action { request =>
    Ok(Json.obj("a" -> 1) ++ Json.obj("b" -> 2))
  }




}
