package $package

import scala.collection.JavaConversions._
import scala.util.control.Breaks._

object Main {

  //val log = org.log4j.

  private def usage() {
    println("""
      |Usage:
      |$ sbt 'run ...'
      |""".stripMargin)
    System.exit(1)
    throw new RuntimeException
  }

  def main(args: Array[String]) {
    if (args.length != 1) usage()
  }
}
