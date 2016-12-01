package controllers
import play.api.mvc._

/**
  * Created by shiva on 30/11/16.
  *
  */
class Json extends Controller {

  case class Location(lat: Double, long: Double)

  case class Resident(name: String, age: Int, role: Option[String])

  case class Place(name: String, location: Location, residents: Seq[Resident])

  import play.api.libs.json._

  implicit val locationWrites = new Writes[Location] {
    def writes(location: Location) = Json.obj(
      "lat" -> location.lat,
      "long" -> location.long
    )
  }

  implicit val residentWrites = new Writes[Resident] {
    def writes(resident: Resident) = Json.obj(
      "name" -> resident.name,
      "age" -> resident.age,
      "role" -> resident.role
    )
  }

  implicit val placeWrites = Json.writes[Place]

  val place = Place(
    "Watership Down",
    Location(51.235685, -1.309197),
    Seq(
      Resident("Fiver", 4, None),
      Resident("Bigwig", 6, Some("Owsla"))
    )
  )

  val json = Json.toJson(place)

def index = Action { request =>
Ok(Json.prettyPrint(Json.toJson(place)))}



}
