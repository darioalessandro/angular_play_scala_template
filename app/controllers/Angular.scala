package controllers

import java.io.File

import controllers.Application._
import play.Play
import play.api.mvc.{Action, Controller}

/**
 * Created by darioalessandro on 9/6/14.
 */
object Angular extends Controller {

  def html(name:String) = Action {implicit request=>
    val projectRoot = Play.application().path()
    val file = new File(projectRoot + getURI(name))
    if (file.exists())
      Ok(scala.io.Source.fromFile(file.getCanonicalPath()).mkString).as("text/html");
    else
      NotFound

  }

  def getURI(any: String): String = any match {
    case "login"    =>  "/public/html/login.html"
    case "main"     =>  "/public/html/main.html"
    case "details"  =>  "/public/html/details.html"
    case _ => "error"
  }
}

