import play.Play.autoImport._
import PlayKeys._

name := """angularjs_scala_template"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

includeFilter in (Assets, LessKeys.less) := "*.less"

excludeFilter in (Assets, LessKeys.less) := "_*.less"
