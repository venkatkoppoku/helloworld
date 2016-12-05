package controllers


import play.api.libs.json.{JsPath, Json, Writes}
import play.api.mvc.{Action, Controller}
import play.api.libs.functional.syntax._


case class Location(lat: Double, long: Double)

case class Place(name: String, location: Location)

object Place {

  var list: List[Place] = {
    List(
      Place(
        "Sandleford",
        Location(51.377797, -1.318965)
      ),
      Place(
        "Watership Down",
        Location(51.235685, -1.309197)
      )
    )
  }

  def save(place: Place) = {
    list = list ::: List(place)
  }
}

class JsW extends Controller {


  implicit val locationWrites :Writes[Location] = (
    (JsPath  \ "lat").write[Double] and
      (JsPath \ "long").write[Double]
    )(unlift( Location.unapply))





  implicit val placeWrites: Writes[Place] = (
    (JsPath \ "name").write[String] and
      (JsPath \ "location").write[Location]
    )(unlift(Place.unapply))

val json = Json.toJson(Place.list)

  def ind = Action { request =>
  Ok(Json.prettyPrint(Json.toJson(json)))
  }
}
