package space.perpetual.chirper.friend.api

import com.fasterxml.jackson.annotation.JsonIgnore
import play.api.libs.json.Json

import scala.collection.immutable.Seq

case class CreateUser (userId: String, name:String)

object CreateUser{
  implicit val createUserJson = Json.format[CreateUser]
}

case class User (userId: String, name: String, friends: Seq[String]) {
  def this(userId: String, name: String) = this(userId, name, Seq.empty)
}

object User {
  implicit val userJson = Json.format[User]

  def apply(createUser: CreateUser):User = User(createUser.userId, createUser.name, Seq())
}