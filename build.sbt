        name := "$project"
     version := "1.0"
scalaVersion := "2.11.6"

scalacOptions ++= Seq("-encoding", "UTF-8", "-feature", "-deprecation")
 javacOptions ++= Seq("-encoding", "UTF-8")
//testOptions in Test += Tests.Argument("-oDF") // stack trace in tests
javaOptions in run += "-Xmx256m"
       fork in run := true
mainClass in (Compile, run) := Some("$package.Main")

net.virtualvoid.sbt.graph.Plugin.graphSettings

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
    // http://jesseeichar.github.io/scala-io-doc/
    "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3-1",
    "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1",
    "log4j" % "log4j" % "1.2.17",
    "org.slf4j" % "slf4j-api" % "1.7.12",
    "org.slf4j" % "slf4j-log4j12" % "1.7.12",
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"
)
