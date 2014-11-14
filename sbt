#!/bin/sh
exec java -Dfile.encoding=UTF8 -server -Xms128m -Xmx512m -Xss1m -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m -jar `dirname $0`/bin/sbt-launch.jar "$@"
