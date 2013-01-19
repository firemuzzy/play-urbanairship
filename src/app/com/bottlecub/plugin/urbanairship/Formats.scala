package com.bottlecub.plugin.urbanairship

import play.api.libs.json.Json._
import play.api.libs.json._

import java.util.Date
import java.text.SimpleDateFormat

object Formats {
  implicit object JsonOptionDateFormatter extends Format[Option[Date]] {

    val dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")

    def writes(date: Option[Date]): JsValue = {
      toJson(
        date.map(
          date => dateFormat.format(date)
        ).getOrElse(
          ""
        )
      )
    }

    def reads(j: JsValue): Option[Date] = {
      try {
        Some(dateFormat.parse(j.as[String]))
      } catch {
        case e => None
      }
    }

  }
}
