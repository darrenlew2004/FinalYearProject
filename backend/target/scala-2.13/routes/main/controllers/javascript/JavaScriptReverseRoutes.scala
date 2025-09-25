// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:21
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseStudentStatsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getByUserId: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StudentStatsController.getByUserId",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/students/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/stats"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAuthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AuthController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/auth/login"})
        }
      """
    )
  
    // @LINE:11
    def refresh: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AuthController.refresh",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/auth/refresh"})
        }
      """
    )
  
    // @LINE:12
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AuthController.logout",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/auth/logout"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHealthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def health: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HealthController.health",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "health"})
        }
      """
    )
  
  }


}
