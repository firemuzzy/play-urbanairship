# UrbanAirship plugin for Play Framework 2

The plugin's wraps bubblefoundry's UrbanAirship library so it can be used in the play framework

 * https://github.com/bubblefoundry/BFUrbanAirship


## Installation

Start by adding the plugin as a dependency, in your `project/Build.scala`

    val appDependencies = Seq(
      "play-urbanairship" % "play-urbanairship_2.9.1" % "1.0-SNAPSHOT"
    )

Then add the repository into your play project resolvers (it is hosted on github taking advantage of github pages)

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      ....
      resolvers += Resolver.url("FireMuzzy GitHub Play Repository", url("http://firemuzzy.github.com/releases/"))(Resolver.ivyStylePatterns),
      ....
    )

We now register the plugin, this is done by creating(or appending) to the `conf/play.plugins` file ('500:' determines the order of priority of how the plugins are loaded)

    500:com.bottlecub.plugin.urbanairship.UrbanAirshipPlugin


## Configuration
Now we need to setup our urban airship keys.

    urbanairship.key="your app token"
    urbanairship.secret="your app secret"
    urbanairship.masterSecret="yout app master secret"


## Usage
Import the following

    import com.bottlecub.plugin.urbanairship._

Then call

    urbanAirshipApi

the 'urbanAirshipApi' command will return BubbleFoundry's UrbanAirship object that you will to to call out to the API

Unfortunately I do not have time to write out a detailed doc of BubbleFoundry's UrbanAirship object, you will have to read the code.


## Push Example

    import com.bottlecub.plugin.urbanairship._
    import com.bubblefoundry.bfurbanairship.{APS, SimplePushMessage}
    ..... 
    (your class and object code)
    .....
    
    val devicesToUpdate = List("APPLE_PUSH_TOKEN_WILL_GO_HERE").toList
    val message = SimplePushMessage(device_tokens = devicesToUpdate, schedule_for = List(), aps = APS("Data update available"))
    urbanAirshipApi.push(message)
