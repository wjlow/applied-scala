# applied-scala

[![Build Status](https://travis-ci.org/realestate-com-au/applied-scala.svg?branch=master)](https://travis-ci.org/github/realestate-com-au/applied-scala)

## Getting Started

Similar to [Intro to Scala](https://github.com/wjlow/intro-to-scala#pre-requisites)

1. Skip this step if you have already done Intro to Scala on your current machine. If you're going to use [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (Community edition is fine), you need to install Java 8 even if you have a newer version of Java installed.

```
brew tap homebrew/cask-versions
brew install homebrew/cask-versions/adoptopenjdk8
```

2. Before the course, please run the following:

```
git clone git@github.com:wjlow/applied-scala.git
cd applied-scala
./auto/test
./auto/start-local
```

This should start the app. Note that the tests should be failing at this point.

3. Now test this out in a new tab.

```
curl http://localhost:9200/movies
```

You should get back `[{"name":"Titanic"}]`. Now press `ctrl+c` in the previous tab to shut down the app.

4. Open up the project in IntelliJ IDEA and make sure it all compiles. Now you're ready to go!

## Open up SBT

Using Docker
```
./auto/sbt
```

or

Using portable SBT
```
./sbt
```

## Run test

```
./auto/test
```

## How to start app

```
./auto/start-local
```

## Schedule

### Day 1

| Time  | Topic/Exercise                                                                                                          |
|-------|-------------------------------------------------------------------------------------------------------------------------|
| 9.15  | :microphone: Day 1 Intro and IO presentation                                                                                              |
| 10.00 | Morning break                                                                                                           |
| 10.15 | :soccer: [IO Exercises](src/main/scala/com/reagroup/exercises/io/IOExercises.scala)                                     |
| 11.15 | :computer: Intro to Http4s (Presentation)                                                                               |
| 12.00 | Lunch                                                                                                                   |
| 13.00 | :soccer: [Circe Exercises](src/main/scala/com/reagroup/exercises/circe/CirceExercises.scala)                            |
| 14.00 | Code walkthrough: [GET all movies (no exercises)](src/main/scala/com/reagroup/appliedscala/urls/fetchallmovies)         |
| 14.30 | :computer: [Endpoint Ex.1: GET movie](./src/main/scala/com/reagroup/appliedscala/urls/fetchmovie)                       |
| 15.30 | Afternoon break                                                                                                         |
| 15.45 | :computer: [Endpoint Ex.2: GET movie?enriched=true](./src/main/scala/com/reagroup/appliedscala/urls/fetchenrichedmovie) |
| 17.00 | End                                                                                                                     |

### Day 2

| Time  | Topic/Exercise                                                                                                 |
|-------|----------------------------------------------------------------------------------------------------------------|
| 9.15  | :microphone: Day 2 Intro                                                                                      |
| 10.00 | Morning break                                                                                                  |
| 10.15 | Validated and Traverse Theory (Presentation)                                                                   |
| 11.15 | :soccer: [Validated Exercises](src/main/scala/com/reagroup/exercises/validated/ValidationExercises.scala)      |
| 12.15 | Lunch                                                                                                          |
| 13.15 | :computer: [Endpoint Ex.3: POST movie](./src/main/scala/com/reagroup/appliedscala/urls/savemovie)              |
| 14.45 | Afternoon break                                                                                                |
| 15.00 | :computer: [Endpoint Ex.4: POST movie/id/review](./src/main/scala/com/reagroup/appliedscala/urls/savereview) |
| 16:15 | :microphone: Wrap-up + Endpoint Ex.2 revisited (w/ Traverse)                                                   |
| 16:45 | End     

## Further reading

- [FAQ](docs/faq.md)
- [Scala Refresher](docs/refresher.md)

## Test queries

Fetch all movies
```
$ curl http://localhost:9200/movies
```

Fetch movie
```
$ curl http://localhost:9200/movies/1
```

Fetch enriched movie

```
$ curl http://localhost:9200/movies/1?enriched=true
```

Save movie

1. Successful save
```
$ curl -H "Accept: application/json" -X POST -d "{\"name\": \"Cars 3\", \"synopsis\": \"Great movie about cars\"}" http://localhost:9200/movies
```

2. Validation errors
```
$ curl -H "Accept: application/json" -X POST -d "{\"name\": \"\", \"synopsis\": \"\"}" http://localhost:9200/movies
```

Save review

1. Successful save
```
$ curl -H "Accept: application/json"  -X POST -d "{\"author\": \"Jack\", \"comment\": \"Great movie huh\"}" http://localhost:9200/movies/1/reviews
```

2. Validation errors

```
$ curl -H "Accept: application/json"  -X POST -d "{\"author\": \"\", \"comment\": \"\"}" http://localhost:9200/movies/1/reviews
```
