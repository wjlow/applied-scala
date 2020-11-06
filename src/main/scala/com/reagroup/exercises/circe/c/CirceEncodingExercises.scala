package com.reagroup.exercises.circe.c

import io.circe._
import io.circe.syntax._

object CirceEncodingExercises {

  case class Person(name: String, age: Int)

  /**
    * Defining encoders and decoders in the companion object means that Scala will always be able to find them.
    *
    * Note: they may be "shadowed" by a higher priority implicit
    */
  object Person {
    /**
      * Create an `Encoder` instance for `Person` by implementing the `apply` method below.
      */
    implicit val personEncoder: Encoder[Person] = (p: Person) => {
      Json.obj(
        "name" -> p.name.asJson,
        "age" -> p.age.asJson
      )
    }
  }


  def encodePerson(person: Person): Json = {
    person.asJson
  }


  /**
    * You can use "semiauto derivation" for encoders too.
    *
    * Hint: Use deriveEncoder
    */
  def encodePersonSemiAuto(person: Person): Json = {
    import io.circe.generic.semiauto._
    implicit val personEncoder: Encoder[Person] = deriveEncoder
    person.asJson
  }
}
