package space.perpetual.chirper.friend.api

import play.api.libs.json.Json

case class FriendId(friendId: String)

object FriendId {
  implicit val friendIdJson = Json.format[FriendId]
}
