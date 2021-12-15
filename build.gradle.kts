plugins {
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("io.micronaut.application") version "3.0.2"
}

version = "0.1"
group = "com.ivyaz.env.endpoint.issue"

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(false)
        annotations("com.ivyaz.env.endpoint.issue.*")
    }
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.security:micronaut-security")
    implementation("io.micronaut.security:micronaut-security-jwt")
    implementation("jakarta.annotation:jakarta.annotation-api")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut.reactor:micronaut-reactor")
    implementation("io.micronaut.reactor:micronaut-reactor-http-client")
    implementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass.set("com.ivyaz.env.endpoint.issue.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
    targetCompatibility = JavaVersion.toVersion("11")
}

