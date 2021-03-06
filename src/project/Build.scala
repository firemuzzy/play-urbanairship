import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play-urbanairship"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      "net.databinder" %% "dispatch-gae" % "0.8.8",
      "net.liftweb" %% "lift-json" % "2.4",
      "net.liftweb" %% "lift-util" % "2.4"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    )

}
