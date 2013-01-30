package com.bottlecub.plugin

import play.api._
import play.api.Play.current
import com.bubblefoundry.bfurbanairship.UrbanAirship

package object urbanairship {
  /**
   * Returns a UrbanAirship api object
   * @return UrbanAirship api object
   */
  def urbanAirshipApi(implicit app: Application): UrbanAirship = {
    app.plugin[UrbanAirshipPlugin].map(_.apiObj).getOrElse(throw new PlayException("UrbanAirshipPlugin is not registered.", "You need to register the plugin with \"500:com.bottlecub.plugin.urbanairship.UrbanAirshipPlugin\" in conf/play.plugins"))
  }

  def urbanAirshipApiOpt(implicit app: Application): Option[UrbanAirship] = {
    app.plugin[UrbanAirshipPlugin].map(_.apiObj)
  }
}
