package controllers

import play.api.libs.json.Json
import play.api.mvc._
/**
  * Created by shiva on 1/12/16.
  */
class hotel extends Controller {

  case class Hotelin(data: Seq[Data], total: Int)

  case class Data(hotelId: String, provider: String, hotelname: String, description: String, starrating: Int, address: String, location: String, hotelimageUrl: String, price: Double, room: Seq[Room])

  case class Room(roomId: String, roomType: String, roomTypeName: String, price: Double, maxGuests: Int, provider: String)

  implicit val roomWrites = Json.writes[Room]

  def writes(room: Room) = Json.obj(
    "roomId" -> room.roomId,
    "roomType" -> room.roomType,
    "roomTypeName" -> room.roomTypeName,
    "price" -> room.price,
    "maxGuests" -> room.maxGuests,
    "provider" -> room.provider
  )


  implicit val dataWrites = Json.writes[Data]

  def writes(data: Data) = Json.obj(
    "hotelId" -> data.hotelId,
    "provider" -> data.provider,
    "hotelname" -> data.hotelname,
    "description" -> data.description,
    "starrating" -> data.starrating,
    "address" -> data.address,
    "location" -> data.location,
    "hotelimageUrl" -> data.hotelimageUrl,
    "price" -> data.price,
    "room" -> data.room
  )

  implicit val hotelinWrites = Json.writes[Hotelin]
  val hotelin = Hotelin(
    Seq(
      Data("1425039", "tourico", "Best Western Princeton Manor Inn and Suites - Demo", "Demo - Best Western Princeton Manor Inn and Suites offers an excellent location with beautiful surroundings coupled with a price that is sure to please \r\n", 2,
        "Demo - 4191 US Highway 1 Monmouth Junction New Jersey 08852", " ", "http://image1.urlforimages.com/Images/1425039/100x100/801266018.jpg",
        73.46, Seq(Room("3", "14484843", "Standard", 73.46, 4, "tourico"))),

        Data("1425039", "tourico", "Best Western Princeton Manor Inn and Suites - Demo", "Demo - Best Western Princeton Manor Inn and Suites offers an excellent location with beautiful surroundings coupled with a price that is sure to please \r\n", 2,
        "Demo - 4191 US Highway 1 Monmouth Junction New Jersey 08852", " ", "http://image1.urlforimages.com/Images/1425039/100x100/801266018.jpg",
        73.46, Seq(Room("3", "14484843", "Standard", 73.46, 4, "tourico"))),


          Data("1425039", "tourico", "Best Western Princeton Manor Inn and Suites - Demo", "Demo - Best Western Princeton Manor Inn and Suites offers an excellent location with beautiful surroundings coupled with a price that is sure to please \r\n", 2,
          "Demo - 4191 US Highway 1 Monmouth Junction New Jersey 08852", " ", "http://image1.urlforimages.com/Images/1425039/100x100/801266018.jpg",
          73.46, Seq(Room("3", "14484843", "Standard", 73.46, 4, "tourico")))




    ),198)


  val json = Json.toJson(hotelin)

  def index = Action { request =>
  Ok(Json.prettyPrint(Json.toJson(hotelin)))
  }

}

















