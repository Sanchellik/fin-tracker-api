plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "ru.gozhan"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(libs.versions.java.get().toInt())
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = libs.versions.spring.cloud.get()

dependencies {

////    Main
//    Spring Boot Starters
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.data.elasticsearch)
    implementation(libs.spring.boot.starter.data.jdbc)
    implementation(libs.spring.boot.starter.data.redis)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.web)

//    Spring Cloud
    implementation(libs.spring.cloud.starter.circuitbreaker.resilience4j)
    implementation(libs.spring.cloud.starter.consul.config)
    implementation(libs.spring.cloud.starter.consul.discovery)

//    Other Spring
    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)
    annotationProcessor(libs.spring.boot.configuration.processor)

//    Databases
    implementation(libs.liquibase.core)
    runtimeOnly(libs.postgresql)

//    Kafka
    implementation(libs.spring.kafka)

//    Tools, libs
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    runtimeOnly(libs.micrometer.registry.prometheus)


////    Test
//    Base
    testRuntimeOnly(libs.junit.platform.launcher)

//    Spring
    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.spring.boot.testcontainers)
    testImplementation(libs.spring.kafka.test)
    testImplementation(libs.spring.security.test)

//    Testcontainers
    testImplementation(libs.testcontainers.consul)
    testImplementation(libs.testcontainers.elasticsearch)
    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.testcontainers.kafka)
    testImplementation(libs.testcontainers.postgresql)

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
