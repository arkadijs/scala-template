#!/bin/sh
exec java -Dfile.encoding=UTF8 -server -Xms1g -Xmx1g -Xss2m -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m -jar `dirname $0`/bin/sbt-launch.jar "$@"
