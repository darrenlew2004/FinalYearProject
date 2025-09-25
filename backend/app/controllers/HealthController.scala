package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import java.time.LocalDateTime

@Singleton
class HealthController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def health = Action { implicit request: Request[AnyContent] =>
    Ok("ok")
  }
} 