package controllers

import play.api.libs.json.Json
import play.api.mvc._


object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def cars = Action {
    Ok(Json.toJson(carsJson))
  }

  def carDetails(id:String)=Action{
    val vehicle:Map[String,String]=carsJson.filter(car=> car.get("id") match{
      case Some(m:String) => m==id
      case None => false
    }).head
    Ok(Json.toJson(vehicle))
  }

  val carsJson= List(
    Map("model"->"Cruze","brand"->"Chevrolet","year"->"2014","id"->"1","img"->"/assets/images/cruze.jpg","description"->"The highly acclaimed Cruze has been setting a new global standard for Chevrolet. Nowhere is this more apparent than in the area of value and design. A result of an orchestrated effort by a select team of designers, engineers and manufacturing talents from all over the world, the Cruze enjoys an exceptional degree of design and refinement in the high volume sector - and is setting a new benchmark in the process. Now, the Cruze gets even better - powered by a new 1.4-litre ECOTEC Turbo engine producing 138bhp and 200Nm of torque - for an efficient and extremely enjoyable ride."),
    Map("model"->"Volt","brand"->"Chevrolet","year"->"2014","id"->"2","img"->"/assets/images/volt.jpg","description"->"With its ingenious propulsion system, unlike traditional hybrid cars, Volt lets you drive on pure electricity for your everyday commute and seamlessly switches to gasoline for longer trips. In fact, owners who charge regularly are averaging more than 900 miles between fill-ups."),
    Map("model"->"ATS","brand"->"Cadillac","year"->"2013","id"->"3","img"->"/assets/images/ats.png","description"->"How did we create a world-class Cadillac like no other? By building a compact luxury sport sedan that’s as nimble and exhilarating as it is luxurious and technologically advanced. By benchmarking the world’s best luxury sport sedans and aiming even higher. And, finally, by testing its limits on some of the most punishing proving grounds on earth."),
    Map("model"->"Malibu","brand"->"Chevrolet","year"->"2012","id"->"4","img"->"/assets/images/malibu.jpg","description"->"The 2013 Malibu moved to GM Epsilon II platform and debuted in the 2013 model year.[38] The new Malibu became a global vehicle, replacing both the North American Malibu and GM Korea vehicles previously sold around the world. The Malibu was unveiled as a show car simultaneously at Auto Shanghai in China (written as \"Mai Rui Bo\"[39]), and on Facebook, on April 18, 2011.[40][41] It was also shown at the New York International Auto Show in New York City later in April."),
    Map("model"->"Corvette","brand"->"Chevrolet","year"->"2014","id"->"5","img"->"/assets/images/corvette.jpg","description"->"With its aggressively sculpted exterior and driver-oriented cockpit, the 2015 Stingray sports car is a beautiful combination of brilliant engineering and purpose-driven design that’s available in both coupe and convertible. From lightweight, carbon-nano-fiber components to a 460-horsepower LT1 engine with available performance exhaust, every element of the 2015 Stingray makes it the quickest, most powerful, most refined standard Corvette ever made.")
  )


}