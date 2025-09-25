package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import java.time.LocalDateTime
import java.util.UUID
import models._
import models.JsonFormats._
import anorm._
import anorm.SqlParser._
import javax.inject.Inject
import play.api.db.DBApi

@Singleton
class AuthController @Inject()(val controllerComponents: ControllerComponents, dbApi: DBApi) extends BaseController {

  private def generateToken(): String = UUID.randomUUID().toString.replaceAll("-", "")

  def login: Action[JsValue] = Action(parse.json) { implicit request: Request[JsValue] =>
    val emailOpt = (request.body \ "email").asOpt[String].orElse((request.body \ "email").toOption.flatMap(_.asOpt[String]))
    val usernameOpt = (request.body \ "username").asOpt[String].orElse((request.body \ "username").toOption.flatMap(_.asOpt[String]))
    val passwordOpt = (request.body \ "password").asOpt[String].orElse((request.body \ "password").toOption.flatMap(_.asOpt[String]))

    (emailOpt.orElse(usernameOpt), passwordOpt) match {
      case (Some(identifier), Some(password)) =>
        implicit val conn = dbApi.database("default").getConnection()
        try {
          val rowOpt: Option[(String, String, String, String, String, String, String, Boolean)] = SQL"""
            SELECT id, username, email, password_hash, role, first_name, last_name, is_active
            FROM users
            WHERE (email = {id} OR username = {id}) AND is_active = TRUE
          """.on('id -> identifier).as((str("id") ~ str("username") ~ str("email") ~ str("password_hash") ~ str("role") ~ str("first_name") ~ str("last_name") ~ bool("is_active")).map {
            case id ~ username ~ email ~ password_hash ~ role ~ first_name ~ last_name ~ is_active =>
              (id, username, email, password_hash, role, first_name, last_name, is_active)
          }.singleOpt)

          rowOpt match {
            case Some((id, username, email, password_hash, role, firstName, lastName, _)) if password_hash == password =>
              val now = LocalDateTime.now()
              val user = User(
                id = id,
                username = username,
                email = email,
                role = Student,
                firstName = firstName,
                lastName = lastName,
                isActive = true,
                lastLogin = Some(now),
                createdAt = now.minusDays(30),
                updatedAt = now
              )
              val token = generateToken()
              val refreshToken = generateToken()
              val response = AuthResponse(
                token = token,
                refreshToken = refreshToken,
                user = user,
                expiresIn = 3600L
              )
              Ok(Json.toJson(response))
            case _ =>
              Unauthorized(Json.obj(
                "message" -> "Invalid credentials",
                "error" -> "Unauthorized"
              ))
          }
        } finally {
          conn.close()
        }
      case _ =>
        BadRequest(Json.obj(
          "message" -> "Missing required fields",
          "error" -> "email/username and password are required"
        ))
    }
  }

  def refresh: Action[JsValue] = Action(parse.json) { implicit request: Request[JsValue] =>
    val refreshTokenOpt = (request.body \ "refreshToken").asOpt[String].orElse((request.body \ "refreshToken").toOption.flatMap(_.asOpt[String]))
    refreshTokenOpt match {
      case Some(_) =>
        val newToken = generateToken()
        Ok(Json.obj(
          "token" -> JsString(newToken),
          "refreshToken" -> JsString(refreshTokenOpt.getOrElse("")),
          "user" -> JsNull,
          "expiresIn" -> JsNumber(3600)
        ))
      case None =>
        BadRequest(Json.obj(
          "message" -> "Missing refreshToken",
          "error" -> "BadRequest"
        ))
    }
  }

  def logout: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok(Json.obj("success" -> true))
  }
}


