import sbt._
import sbt.Keys._
import com.github.siasia.WebPlugin
import com.zantekk.sbt.{ZantekkPlugin, ZantekkKeys, LiftPlugin, LiftKeys}
import ZantekkKeys._
import LiftKeys._

object Build extends sbt.Build {

  val $name;format="camel"$ = Project(id = "$name;format="norm"$", base = file("."), settings = appSettings)

  val appSettings :Seq[Setting[_]] = Project.defaultSettings ++ ZantekkPlugin.defaultSettings ++
    LiftPlugin.liftDefaultSettings ++ WebPlugin.webSettings ++ Seq(
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    startYear := Some(2012),
    scalaVersion := "$scala_version$",
    liftVersion := "$lift_version$",
    liftScalateModule_? := true,
    zantekkSnapshotResolvers_? := true,
    libraryDependencies ++= LibraryDependencies.webLibs
  )

  object LibraryDependencies {
    lazy val scalateJrebel = "org.fusesource.scalate" % "scalate-jrebel" % "1.5.3"  % "provided"
    lazy val scalaMd = "org.fusesource.scalamd" % "scalamd" % "1.5" % "runtime"
    lazy val jettyWebapp = "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container;test"
    lazy val specs2 = "org.specs2" %% "specs2" % "1.12.1" % "test"

    lazy val webLibs = Seq[ModuleID](scalateJrebel, scalaMd, jettyWebapp, specs2)
  }
}
