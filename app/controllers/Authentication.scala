package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/**
 * Created by darioalessandro on 9/6/14.
 */
object Authentication extends Controller {

  def login= Action{ implicit request=>
    request.body.asJson match {
      case Some(json) =>
          val user: String= (json \ "email").as[String]
          val pass: String= (json \ "pass").as[String]

          if(user=="dario.talarico@gm.com" && pass=="generalmotors")
            Ok("welcome")
          else
            Unauthorized

      case None => Unauthorized
    }
  }

}
