package com.reagroup.exercises.circe.encoding

import CirceEncodingExercises._
import io.circe._
import io.circe.literal._
import io.circe.syntax._
import org.specs2.mutable.Specification

class CirceEncodingExercisesSpec extends Specification {
  "encodePerson" should {

    "convert Person to Json" in {
      val person = Person("scala", 20)
      val actual = encodePerson(person)
      val expected = Json.obj("name" -> "scala".asJson, "age" -> 20.asJson)

      actual must_=== expected
    }

  }

  "encodePersonSemiAuto" should {

    "convert Person to Json" in {
      val person = Person("scala", 20)
      val actual = encodePersonSemiAuto(person)
      val expected = Json.obj("name" -> "scala".asJson, "age" -> 20.asJson)

      actual must_=== expected
    }

  }
}
