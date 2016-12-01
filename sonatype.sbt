// To sync with Maven central, you need to supply the following information:
pomExtra in Global := {
  <url>https://github.com/criteo/vizsql</url>
  <licenses>
    <license>
      <name>Apache 2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <connection>scm:git:github.com/criteo/vizsql.git</connection>
    <developerConnection>scm:git:git@github.com:criteo/vizsql.git</developerConnection>
    <url>github.com/criteo/vizsql</url>
  </scm>
  <developers>
    <developer>
      <name>Guillaume Bort</name>
      <email>g.bort@criteo.com</email>
      <url>https://github.com/guillaumebort</url>
      <organization>Criteo</organization>
      <organizationUrl>http://www.criteo.com</organizationUrl>
    </developer>
  </developers>
}

pgpPassphrase := Some(sys.env("SONATYPE_PASSWORD").toArray)
pgpSecretRing := file(".travis/secring.gpg")
pgpPublicRing := file(".travis/pubring.gpg")

usePgpKeyHex("85532E9E")

credentials += Credentials(
  "Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  "crite-oss",
  sys.env("SONATYPE_PASSWORD")
)
