@echo off
set SCRIPT_DIR=%~dp0
java -Dfile.encoding=UTF8 -Xms128m -Xmx512m -Xss1m -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m -jar "%SCRIPT_DIR%bin\sbt-launch.jar" %*
