
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Course Risk Prediction System</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*9.54*/routes/*9.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*9.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.59*/routes/*10.65*/.Assets.versioned("images/favicon.png")),format.raw/*10.104*/("""">
    </head>
    <body>
        <div id="root">
            <h1>Course Risk Prediction System</h1>
            <p>Backend API is running successfully!</p>
            <p>API Endpoints:</p>
            <ul>
                <li><a href="/health">Health Check</a></li>
                <li><a href="/api/v1/students">Students API</a></li>
                <li><a href="/api/v1/courses">Courses API</a></li>
            </ul>
        </div>
        <script src=""""),_display_(/*23.23*/routes/*23.29*/.Assets.versioned("javascripts/main.js")),format.raw/*23.69*/("""" type="text/javascript"></script>
    </body>
</html> """))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 1725955c6ed9db05985e44d9cda8ed3dca323311
                  MATRIX: 722->1|818->3|848->7|1138->271|1152->277|1214->318|1303->380|1318->386|1379->425|1878->897|1893->903|1954->943
                  LINES: 21->1|26->1|28->3|34->9|34->9|34->9|35->10|35->10|35->10|48->23|48->23|48->23
                  -- GENERATED --
              */
          