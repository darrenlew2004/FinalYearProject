// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:21
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReverseStudentStatsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getByUserId(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/students/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/stats")
    }
  
  }

  // @LINE:18
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def login: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/auth/login")
    }
  
    // @LINE:11
    def refresh: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/auth/refresh")
    }
  
    // @LINE:12
    def logout: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/auth/logout")
    }
  
  }

  // @LINE:7
  class ReverseHealthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def health: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "health")
    }
  
  }


}
