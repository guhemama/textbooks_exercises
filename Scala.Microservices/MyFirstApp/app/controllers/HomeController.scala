package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index() = Action {
    Ok(views.html.index())
  }

  def hello(name: String) = Action {
    Ok("Hello " + name)
  }

  def addUser() = Action { implicit request =>
    val body = request.body

    body.asFormUrlEncoded match {
      case Some(map) =>
        Ok(s"The user `${map("name")} was created")
      case None => BadRequest("Unknown format")
    }

  }
}