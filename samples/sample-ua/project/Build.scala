import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "sample-ua"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "play-urbanairship" % "play-urbanairship_2.9.1" % "1.0-SNAPSHOT"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      resolvers += "Local Play Repository" at "file:/Users/mcharkin/play/repository/local"
    )

}
