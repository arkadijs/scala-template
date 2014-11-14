package $package

import scala.collection.JavaConversions._
import scala.util.control.Breaks._

object Main {

  val log = org.slf4j.LoggerFactory.getLogger(getClass)

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
    println(s"Hello ${args.head}!")
    log.info("See ya {}!", args.head)
  }
}
