import sbt._
import sbt.Keys._
import com.github.siasia.WebPlugin
import com.zantekk.sbt.sbtzantekk.{ZantekkPlugin, ZantekkKeys}
import com.zantekk.sbt.lift.{LiftPlugin, LiftKeys}
import ZantekkKeys._
import LiftKeys._

object Build extends sbt.Build {

  val $name;format="camel"$ = Project(id = "$name;format="norm"$", base = file("."), settings = appSettings)

  val appSettings :Seq[Setting[_]] = Project.defaultSettings ++ ZantekkPlugin.defaultSettings ++
    LiftPlugin.liftSettings ++ WebPlugin.webSettings ++ Seq(
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    startYear := Some(2013),
    scalaVersion := "$scala_version$",
    liftVersion := "$lift_version$",
    zantekkSnapshotResolvers <<= liftVersion.apply(_ contains("-SNAPSHOT")),
    libraryDependencies ++= LibraryDependencies.webLibs,
    LiftPlugin.addScalateModule
  )

  object LibraryDependencies {
    lazy val scalateJrebel = "org.fusesource.scalate" %% "scalate-jrebel" % "1.6.1  % "provided"
    lazy val jettyWebapp = "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container;test"
    lazy val specs2 = "org.specs2" %% "specs2" % "1.12.1" % "test"

    lazy val webLibs = Seq[ModuleID](scalateJrebel, jettyWebapp, specs2)
  }
}
