@echo off
if "%~1" == "" goto usage
java -cp "%~dp0\bin" ScalaProj %~dp0 %1
exit /b
:usage
echo "Usage: scalaproj <project-dir>"
exit /b 1
