package com.reagroup.exercises.circe.a


import io.circe._


object CirceParsingExercises {
  /**
    * Json Parsing
    *
    * Hint: `parser` is already in scope (imported through `io.circe._`)
    *
    * Why is the return type an `Either`?
    */
  def strToJson(str: String): Either[ParsingFailure, Json] = {
    ???
  }

  /**
    * Try make a syntax error in the following Json document and compile.
    * What happens?
    */
  val validJson: Json = {
    import io.circe.literal._

    json"""
      {
        "someKey": "someValue",
        "anotherKey": "anotherValue"
      }
    """
  }
}
