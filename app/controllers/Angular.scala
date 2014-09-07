package controllers

import play.api.mvc.{Action, Controller}

/**
 * Created by darioalessandro on 9/6/14.
 */
object Angular extends Controller {

  def html(name:String) = Action {implicit request=>
    Ok(views.html.index("Your new application is ready."))
  }

  def controller(name:String) = Action {implicit request=>
    Ok(views.html.index("Your new application is ready."))
  }

}
