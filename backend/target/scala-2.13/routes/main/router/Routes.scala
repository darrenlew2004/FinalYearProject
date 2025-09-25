// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HealthController_2: controllers.HealthController,
  // @LINE:10
  AuthController_0: controllers.AuthController,
  // @LINE:15
  StudentStatsController_3: controllers.StudentStatsController,
  // @LINE:18
  HomeController_4: controllers.HomeController,
  // @LINE:21
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HealthController_2: controllers.HealthController,
    // @LINE:10
    AuthController_0: controllers.AuthController,
    // @LINE:15
    StudentStatsController_3: controllers.StudentStatsController,
    // @LINE:18
    HomeController_4: controllers.HomeController,
    // @LINE:21
    Assets_1: controllers.Assets
  ) = this(errorHandler, HealthController_2, AuthController_0, StudentStatsController_3, HomeController_4, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HealthController_2, AuthController_0, StudentStatsController_3, HomeController_4, Assets_1, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """health""", """controllers.HealthController.health"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/auth/login""", """controllers.AuthController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/auth/refresh""", """controllers.AuthController.refresh"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/auth/logout""", """controllers.AuthController.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/students/""" + "$" + """userId<[^/]+>/stats""", """controllers.StudentStatsController.getByUserId(userId:String)"""),
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:7
  private lazy val controllers_HealthController_health0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("health")))
  )
  private lazy val controllers_HealthController_health0_invoker = createInvoker(
    HealthController_2.health,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HealthController",
      "health",
      Nil,
      "GET",
      this.prefix + """health""",
      """ Health check""",
      Seq()
    )
  )

  // @LINE:10
  private lazy val controllers_AuthController_login1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/auth/login")))
  )
  private lazy val controllers_AuthController_login1_invoker = createInvoker(
    AuthController_0.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthController",
      "login",
      Nil,
      "POST",
      this.prefix + """api/v1/auth/login""",
      """ API v1""",
      Seq()
    )
  )

  // @LINE:11
  private lazy val controllers_AuthController_refresh2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/auth/refresh")))
  )
  private lazy val controllers_AuthController_refresh2_invoker = createInvoker(
    AuthController_0.refresh,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthController",
      "refresh",
      Nil,
      "POST",
      this.prefix + """api/v1/auth/refresh""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private lazy val controllers_AuthController_logout3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/auth/logout")))
  )
  private lazy val controllers_AuthController_logout3_invoker = createInvoker(
    AuthController_0.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthController",
      "logout",
      Nil,
      "POST",
      this.prefix + """api/v1/auth/logout""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private lazy val controllers_StudentStatsController_getByUserId4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/students/"), DynamicPart("userId", """[^/]+""", encodeable=true), StaticPart("/stats")))
  )
  private lazy val controllers_StudentStatsController_getByUserId4_invoker = createInvoker(
    StudentStatsController_3.getByUserId(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.StudentStatsController",
      "getByUserId",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/v1/students/""" + "$" + """userId<[^/]+>/stats""",
      """ Student stats""",
      Seq()
    )
  )

  // @LINE:18
  private lazy val controllers_HomeController_index5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_index5_invoker = createInvoker(
    HomeController_4.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:21
  private lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HealthController_health0_route(params@_) =>
      call { 
        controllers_HealthController_health0_invoker.call(HealthController_2.health)
      }
  
    // @LINE:10
    case controllers_AuthController_login1_route(params@_) =>
      call { 
        controllers_AuthController_login1_invoker.call(AuthController_0.login)
      }
  
    // @LINE:11
    case controllers_AuthController_refresh2_route(params@_) =>
      call { 
        controllers_AuthController_refresh2_invoker.call(AuthController_0.refresh)
      }
  
    // @LINE:12
    case controllers_AuthController_logout3_route(params@_) =>
      call { 
        controllers_AuthController_logout3_invoker.call(AuthController_0.logout)
      }
  
    // @LINE:15
    case controllers_StudentStatsController_getByUserId4_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_StudentStatsController_getByUserId4_invoker.call(StudentStatsController_3.getByUserId(userId))
      }
  
    // @LINE:18
    case controllers_HomeController_index5_route(params@_) =>
      call { 
        controllers_HomeController_index5_invoker.call(HomeController_4.index())
      }
  
    // @LINE:21
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
