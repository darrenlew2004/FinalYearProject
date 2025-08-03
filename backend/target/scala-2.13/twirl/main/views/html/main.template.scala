
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>"""),_display_(/*8.17*/title),format.raw/*8.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*9.54*/routes/*9.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*9.101*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.59*/routes/*10.65*/.Assets.versioned("images/favicon.png")),format.raw/*10.104*/("""">
    </head>
    <body>
        """),_display_(/*13.10*/content),format.raw/*13.17*/("""
        """),format.raw/*14.9*/("""<script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.versioned("javascripts/main.js")),format.raw/*14.69*/("""" type="text/javascript"></script>
    </body>
</html> """))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: 491760bf3ba95a815b40d621fd6bb0c68b76aaaf
                  MATRIX: 733->1|858->31|888->35|1087->208|1112->213|1201->276|1215->282|1277->323|1366->385|1381->391|1442->430|1507->468|1535->475|1572->485|1613->499|1628->505|1689->545
                  LINES: 21->1|26->1|28->3|33->8|33->8|34->9|34->9|34->9|35->10|35->10|35->10|38->13|38->13|39->14|39->14|39->14|39->14
                  -- GENERATED --
              */
          