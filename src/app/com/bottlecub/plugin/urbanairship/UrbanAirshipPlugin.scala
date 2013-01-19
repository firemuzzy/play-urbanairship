package com.bottlecub.plugin.urbanairship

import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.libs.ws.WS
import com.bubblefoundry.bfurbanairship.UrbanAirship
import net.liftweb.common._


class UrbanAirshipPlugin(app: Application) extends Plugin {

  lazy val configuration = app.configuration.getConfig("urbanairship").getOrElse(Configuration.empty)

  case class UrbanAirshipConf(
    val key: String,
    val secret: String,
    val masterSecret: String
  ) {

  }

  override def enabled = !configuration.subKeys.isEmpty

  override def onStart() {
    conf
    play.api.Logger.info("initialized UrbanAirship plugin")
  }

  override def onStop(){
  }

  /**
   * Returns a UrbanAirshipConf that has been configured in application.conf
   * @return an UrbanAirshipConf
   */
  lazy val conf: UrbanAirshipConf = {
    val key = configuration.getString("key").getOrElse(throw new PlayException("UrbanAirshipPlugin requires an key", "define urbanairship.key in your play configuration file"))
    val secret = configuration.getString("secret").getOrElse(throw new PlayException("UrbanAirshipPlugin requires a secret", "define urbanairship.secret in your play configuration file"))
    val masterSecret = configuration.getString("masterSecret").getOrElse(throw new PlayException("UrbanAirshipPlugin requires a masterSecret", "define urbanairship.masterSecret in your play configuration file"))

    UrbanAirshipConf(key = key, secret = secret, masterSecret = masterSecret)
  }

  /**
   * Returns the BubbleFoundry UrbanAirship obj
   * @return An UrbanAirship API obj
   */
  lazy val apiObj: UrbanAirship = {
    val key = this.conf.key
    val secret = this.conf.secret
    val masterSecret = this.conf.masterSecret

    new UrbanAirship(key, Full(secret), Full(masterSecret), appengine = false)
  }
}