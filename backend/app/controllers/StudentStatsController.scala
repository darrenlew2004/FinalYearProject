package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import play.api.db.DBApi
import anorm._
import anorm.SqlParser._

@Singleton
class StudentStatsController @Inject()(val controllerComponents: ControllerComponents, dbApi: DBApi) extends BaseController {

  def getByUserId(userId: String) = Action { implicit request =>
    implicit val conn = dbApi.database("default").getConnection()
    try {
      val parser = (str("id") ~ str("user_id") ~ str("department") ~ str("major") ~ double("gpa") ~ double("attendance_rate") ~ int("previous_failures") ~ int("behavior_incidents") ~ get[Option[String]]("recommendations")).map {
        case id ~ uid ~ dept ~ major ~ gpa ~ attendance ~ prev ~ incidents ~ rec =>
          Json.obj(
            "id" -> id,
            "userId" -> uid,
            "department" -> dept,
            "major" -> major,
            "gpa" -> gpa,
            "attendanceRate" -> attendance,
            "previousFailures" -> prev,
            "behaviorIncidents" -> incidents,
            "recommendations" -> JsString(rec.getOrElse(""))
          )
      }

      val rowOpt = SQL"""
        SELECT * FROM student_stats WHERE user_id = {uid}
      """.on('uid -> userId).as(parser.singleOpt)

      rowOpt match {
        case Some(js) => Ok(js)
        case None => NotFound(Json.obj("message" -> "Student stats not found"))
      }
    } finally {
      conn.close()
    }
  }
}


