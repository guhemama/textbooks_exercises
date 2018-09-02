package space.perpetual.chirper.friend.impl

import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader, LagomServer}
import com.softwaremill.macwire.wire
import com.typesafe.conductr.bundlelib.play.api.ConductRApplicationComponents
import play.api.libs.ws.ahc.AhcWSComponents
import space.perpetual.chirper.friend.api.FriendService

abstract class FriendModule (context: LagomApplicationContext) extends LagomApplication(context) with AhcWSComponents {
  override lazy val lagomServer: LagomServer = serverFor[FriendService](wire[FriendServiceImpl])
}

class FriendApplicationLoader extends LagomApplicationLoader {
  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new FriendModule(context) with LagomDevModeComponents

  override def load(context: LagomApplicationContext): LagomApplication =
    new FriendModule(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[FriendService])
}