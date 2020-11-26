name := "EulerProject"
version := "2020.10.14.01"

lazy val `pj-euler` = (project in file("."))
  .enablePlugins(PlayScala)

scalaVersion := "2.13.4"

resolvers ++= Seq(
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
  , "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
)

libraryDependencies ++= Seq(
  guice // for DI
  , ehcache // for cache
  , ws // for WebSocket Protocol
  , specs2 % Test
  , "com.typesafe.akka" %% "akka-http" % "10.2.1"
)

unmanagedResourceDirectories in Test += baseDirectory.value / "target/web/public/sample"
