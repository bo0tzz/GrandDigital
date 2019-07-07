plugins {
    java
    application
}

group = "me.bo0tzz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mariadb.jdbc", "mariadb-java-client", "2.4.0")
    implementation("com.google.code.gson", "gson", "2.8.5")

    testCompile("junit", "junit", "4.12")
}

application {
    mainClassName = "me.bo0tzz.granddigital.Main"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}