package com.reagroup.exercises.circe.a

import CirceParsingExercises.strToJson
import io.circe.literal._
import org.specs2.mutable.Specification

class CirceParsingExercisesSpec extends Specification {
  "strToJson" should {

    "parse valid Json" in {
      val json = json"""{"name": "scala"}"""
      val errOrJson = strToJson(json.noSpaces)
      errOrJson must_=== Right(json)
    }

    "return error for invalid Json" in {
      val errOrJson = strToJson("""{"scala"}""")
      errOrJson must beLeft
    }
  }
}
