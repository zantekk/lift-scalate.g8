import sbt._
import sbt.Keys._
import com.github.siasia.WebPlugin

object Build extends sbt.Build {

  val liftVersion = SettingKey[String]("lift-version", "Version number of the Lift Web Framework.")

  val $name;format="camel"$ = Project(id = "$name;format="norm"$", base = file("."), settings = appSettings)

  val appSettings :Seq[Setting[_]] = Project.defaultSettings ++ WebPlugin.webSettings ++ Seq(
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    startYear := Some(2012),
    scalaVersion := "$scala_version$",
    liftVersion := "$lift_version$",
    libraryDependencies <<= (liftVersion) { (lv: String) =>
      Seq(
        "net.liftweb" %% "lift-webkit" % lv % "compile",
        "net.liftweb" %% "lift-testkit" % lv % "test",
        "net.liftmodules" %% "lift-jquery-module" % (liftVersion + "-" + "$lift_jquery_version$") % "compile",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container;test",
        "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
        "ch.qos.logback" % "logback-classic" % "1.0.7" % "compile",
        "org.specs2" %% "specs2" % "1.12.1" % "test"
      )
    }
  )
}
