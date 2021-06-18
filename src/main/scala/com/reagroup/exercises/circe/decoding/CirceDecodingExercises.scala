package com.reagroup.exercises.circe.decoding

import io.circe.Decoder.Result
import io.circe._

object CirceDecodingExercises {

  case class Person(name: String, age: Int)

  /**
    * Defining encoders and decoders in the companion object means that Scala will always be able to find them.
    *
    * Note: they may be "shadowed" by a higher priority implicit
    */
  object Person {

    /**
      * Let's create a decoder so we can work with JSON objects.
      * You'll be provided with a cursor to traverse the JSON and pluck elements from keys.
      *
      * Construct a `Decoder` instance for `Person`, that uses the `HCursor` to
      * navigate through the `Json`.
      *
      * Use the provided `HCursor` to navigate through the `Json`, and try to
      * create an instance of `Person`.
      *
      * Example JSON:
      * {
      *   "name": "Jack",
      *   "age": 16
      * }
      *
      * Hint: Use `cursor.downField("name")` to navigate to the `"name"` field.
      * `cursor.downField("name").as[String]` will navigate to the `"name"` field
      * and attempt to decode the value as a `String`.
      *
      * Alternatively, you can use `cursor.get[String]("name")` to do the same thing.
      *
      * Once you have retrieved the `name` and `age`, construct a `Person`!
      *
      * Remember: `Result[A]` is an alias for `Either[DecodingFailure, A]`
      *
      * Question: Why is the return type an `Either`?
      *
      * For more comprehensive cursor docs:
      * https://circe.github.io/circe/api/io/circe/HCursor.html
      *
      * For more comprehensive examples:
      * https://circe.github.io/circe/codecs/custom-codecs.html
      */
    // note: a lot of boilerplate can be removed. Try pressing alt-enter with your
    // cursor over "new Decoder[Person]" above. This works because Decoder is a trait with
    // a single abstract method.
    implicit val personDecoder: Decoder[Person] = new Decoder[Person] {
      def apply(cursor: HCursor): Result[Person] = {
        ???
      }
    }
  }

  /**
    * Use the `.as` method on JSON to specify the type you want to convert the JSON to.
    *
    * Since we're likely to be casting it to a `Person`,
    * Scala will look for an implicit `Decoder[Person]` in the following places:
    * - The current scope (current method, class, file)
    * - Imports
    * - The companion object of `Decoder`
    * - The companion object of `Person` (bingo!)
    *
    * We won't get into the weeds of how this works. For those interested, what we implemented above
    * can be read as "Person is an instance of the Decoder type class".
    *
    * More info on type classes:
    * - https://typelevel.org/cats/typeclasses.html
    * - https://www.parsonsmatt.org/2017/01/07/how_do_type_classes_differ_from_interfaces.html
    */
  def decodePerson(json: Json): Either[DecodingFailure, Person] = {
    // Turn this Json to a Person using the `.as` method
    ???
  }

  /**
    * Sick of writing custom encoders? You can use "semiauto derivation"
    * to create an `Decoder` instance for you using a Scala feature called macros.
    *
    * The downside to this is the keys of your `Json` are now tightly coupled with
    * how you have named the fields inside `Person`
    *
    * Hint: Use `deriveDecoder`
    *
    * For more comprehensive examples:
    * https://circe.github.io/circe/codecs/semiauto-derivation.html
    */
  def decodePersonSemiAuto(json: Json): Either[DecodingFailure, Person] = {
    import io.circe.generic.semiauto._
    implicit val personDecoder: Decoder[Person] = ???

    ???
  }

  /**
    * Parse and then decode
    *
    * Hint: Use `parser.decode`, which does both at the same time.
    */
  def strToPerson(str: String): Either[Error, Person] = {
    import io.circe.generic.semiauto._
    implicit val personDecoder: Decoder[Person] = ???

    ???
  }
}
