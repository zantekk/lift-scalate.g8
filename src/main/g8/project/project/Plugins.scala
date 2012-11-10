import sbt._
import Keys._

object Plugins extends Build {

  lazy val root = Project("plugins", file(".")) settings(
    resolvers ++= Seq(
      Resolver.url("Zantekk Ivy Release Artefacts", url("http://repo.zantekk.com/zantekk/ivy-release/"))(
        Resolver.ivyStylePatterns
      ),
      Resolver.url("Zantekk Ivy Snapshot Artefacts", url("http://repo.zantekk.com/zantekk/ivy-snapshot/"))(
        Resolver.ivyStylePatterns
      ),
      Resolver.url("Zantekk Ivy External Release Artefacts", url("http://repo.zantekk.com/zantekk/ext-ivy-release/"))(
        Resolver.ivyStylePatterns
      ),
      Resolver.url("Zantekk Ivy External Snapshot Artefacts", url("http://repo.zantekk.com/zantekk/ext-ivy-snapshot/"))(
        Resolver.ivyStylePatterns
      )
    ),
    addSbtPlugin("com.zantekk.sbt" % "sbt-zantekk" % "1.1.0-+"),
    addSbtPlugin("in.drajit.sbt" % "sbt-yui-compressor" % "0.2.0"),
    libraryDependencies += "com.github.siasia" %% "xsbt-web-plugin" % "0.12.0-0.2.11.1"
    )
}