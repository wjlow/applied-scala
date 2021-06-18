package com.reagroup.exercises.circe.encoding

import io.circe._
import io.circe.syntax._

/**
 * We suggest you go through CirceDecodingExercises before this.
 * There are additional docs in that file that teach you some of the concepts in here.
 */
object CirceEncodingExercises {

  case class Person(name: String, age: Int)

  /**
    * Now we know how to decode. Let's write implement the Encoder type class for Person.
    */
  object Person {
    /**
      * Create an `Encoder` instance for `Person` by implementing the lambda.
      * Note: if you haven't converted the personDecoder in the previous exercise into a
      * "single abstract method", this is what it looks like.
      */
    implicit val personEncoder: Encoder[Person] = (p: Person) => {
      ???
    }
  }


  /**
    * Let's create a JSON object from our Person.
    *
    * Use the `.as` extension method on `person` to convert it to a `Json`
    */
  def encodePerson(person: Person): Json = {
    ???
  }


  /**
    * You can use "semiauto derivation" for encoders too.
    *
    * Hint: Use deriveEncoder
    */
  def encodePersonSemiAuto(person: Person): Json = {
    import io.circe.generic.semiauto._
    implicit val personEncoder: Encoder[Person] = ???
    ???
  }
}
