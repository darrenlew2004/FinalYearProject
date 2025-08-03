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
  HealthController_0: controllers.HealthController,
  // @LINE:10
  api_Routes_0: api.Routes,
  // @LINE:13
  HomeController_1: controllers.HomeController,
  // @LINE:16
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HealthController_0: controllers.HealthController,
    // @LINE:10
    api_Routes_0: api.Routes,
    // @LINE:13
    HomeController_1: controllers.HomeController,
    // @LINE:16
    Assets_2: controllers.Assets
  ) = this(errorHandler, HealthController_0, api_Routes_0, HomeController_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HealthController_0, api_Routes_0, HomeController_1, Assets_2, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """health""", """controllers.HealthController.health"""),
    prefixed_api_Routes_0_1.router.documentation,
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
    HealthController_0.health,
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
  private val prefixed_api_Routes_0_1 = Include(api_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "api/v1"))

  // @LINE:13
  private lazy val controllers_HomeController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_index2_invoker = createInvoker(
    HomeController_1.index(),
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

  // @LINE:16
  private lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""", encodeable=false)))
  )
  private lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HealthController_health0_invoker.call(HealthController_0.health)
      }
  
    // @LINE:10
    case prefixed_api_Routes_0_1(handler) => handler
  
    // @LINE:13
    case controllers_HomeController_index2_route(params@_) =>
      call { 
        controllers_HomeController_index2_invoker.call(HomeController_1.index())
      }
  
    // @LINE:16
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
