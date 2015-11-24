name         := "dhm-gating"
organization := "com.siemens.icvro"
version      := "1.0"
scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
//  val akkaV       = "2.4.0"
//  val akkaStreamV = "2.0-M1"
  val scalaTestV  = "2.2.4"
  Seq(
//    "com.typesafe.akka" %% "akka-actor"                  % akkaV,
//    "com.typesafe.akka" %% "akka-stream-experimental"    % akkaStreamV,
//    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamV,
//    "com.typesafe.akka" %% "akka-http-experimental"      % akkaStreamV,
//    "com.typesafe.akka" %% "akka-testkit"                % akkaV            % "test",
    "org.scalatest"     %% "scalatest"                   % scalaTestV       % "test"
  )
}
    