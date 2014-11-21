### A template for bare Scala project

To start learning or teaching Scala I use this template to quickly bootstrap minimalistic Scala project. It includes SBT for canonical Scala workflow and Maven pom for universal Java IDE integration.

#### Linux, Mac

    $ scala-template/scalaproj my-project
    $ cd my-project
    $ ./sbt test
    $ ./sbt
    > run world

#### Windows

    c:\downloads> scala-template\scalaproj my-project
    c:\downloads> cd my-project
    c:\downloads\my-project> sbt test
    c:\downloads\my-project> sbt
    > run world
