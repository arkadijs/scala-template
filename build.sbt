name := "$project"

version := "1.0"

scalaVersion := "2.10.2"

scalacOptions ++= Seq("-encoding", "UTF-8")

javacOptions ++= Seq("-encoding", "UTF-8")

//testOptions in Test += Tests.Argument("-oDF")

javaOptions in run += "-Xmx2g"

fork in run := true

mainClass := Some("$package.Main")

resolvers ++= Seq(
    Classpaths.typesafeResolver,
    "Local repo"    at "file:///"+Path.userHome.absolutePath+"/.m2/repository",
    "Maven repo"    at "http://repo1.maven.org/maven2",
    "Spring repo"   at "http://repo.springsource.org/libs-release",
    "Apache repo"   at "https://repository.apache.org/content/repositories/releases",
    "JBoss repo"    at "http://repository.jboss.org/nexus/content/groups/public-jboss",
    "Sonatype repo" at "https://oss.sonatype.org/content/repositories/releases",
    "Mvnrepository" at "http://mvnrepository.com/artifact"
)

libraryDependencies ++= Seq(
    "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.2",
    "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2",
    "log4j" % "log4j" % "1.2.17",
    "org.slf4j" % "slf4j-api" % "1.7.5",
    "org.slf4j" % "slf4j-log4j12" % "1.7.5",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)
