package controllers


import play.api.libs.json.Json
import play.api.mvc._

/**
  * Created by shiva on 1/12/16.
  */
class jswr extends Controller{
  case class Address(number: Int, street: String)
  case class Person(name: String, address: Address)
  implicit val addressWrites = Json.writes[Address]
  def writes(adress:Address)= Json.obj(
    "number" -> adress.number,
    "street"  -> adress.street
  )

  implicit val personWrites = Json.writes[Person]
  val person = Person(
    "venky",
    Address(73,"agraharam")
  )

  val json= Json.toJson(person)

  def indx = Action { request =>
  Ok(Json.prettyPrint(Json.toJson(person)))
  }





}


