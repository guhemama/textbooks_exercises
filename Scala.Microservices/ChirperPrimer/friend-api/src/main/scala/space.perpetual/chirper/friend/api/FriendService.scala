package space.perpetual.chirper.friend.api

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import scala.collection.immutable.Seq

trait FriendService extends Service {
  def getUser(id: String): ServiceCall[NotUsed, User]
  def createUser(): ServiceCall[CreateUser, Done]
  def addFriend(userId: String): ServiceCall[FriendId, Done]
  def getFollowers(userId: String): ServiceCall[NotUsed, Seq[String]]

  override def descriptor(): Descriptor = {
    import Service._

    named("friendservice").withCalls(
      pathCall("/api/users/:id", getUser _),
      namedCall("/api/users", createUser _),
      pathCall("/api/users/:userId/friends", addFriend _),
      pathCall("/api/users/:id/followers", getFollowers _)
    ).withAutoAcl(true)
  }
}