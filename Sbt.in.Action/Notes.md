## Getting started

Setting up sbt sbt provides installation packages for most operating system variants at http:// www.scala-sbt.org/download.html

By default, sbt includes only the bare minimum it needs to launch builds. The first time you run a project, sbt needs to download the remaining portions required, as well as compile the local project’s build definition. This process happens only the first time a depen- dency is needed or when your build changes.

### Setting up a build

Every project using sbt should have two files:

* project/build.properties
* build.sbt

The build.properties file is used to inform sbt which version it should use for your build, and the build.sbt file defines the actual settings for your build.

Because sbt includes settings for a default project, it requires no build files to run for the simplest of builds. But it’s a good practice to always manually create the project/ build.properties and build.sbt files.

After setting up a build file, when you run the sbt command, it will load the settings from those files.

`sbt help` will list all available tasks

### Tasks

Tasks are things that sbt build can do for you, like compiling a project creating documentation, or running tests. By running `sbt tasks` you can see a list of all available tasks.

### Settings

By running `sbt settings` you can see a list of all project settings.

## Running and compiling

To compile a project, run `compile`.
To run a project, run `run`.
To run an interpreter against the project, run `console`.

## Testing

To run the test suite, run `test`.
To run the test suite in "watch mode", run `~test`.
TO run an specific set of tests, run `testOnly`.