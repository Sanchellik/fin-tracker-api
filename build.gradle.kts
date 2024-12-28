plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.gozhan"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
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

extra["springCloudVersion"] = "2024.0.0"

dependencies {

////    Main
//    Spring Boot Starters
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")

//    Spring Cloud
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.springframework.cloud:spring-cloud-starter-consul-config")
    implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")

//    Other Spring
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

//    Databases
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

//    Kafka
    implementation("org.springframework.kafka:spring-kafka")

//    Tools, libs
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")


////    Test
//    Base
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

//    Spring
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.springframework.security:spring-security-test")

//    Testcontainers
    testImplementation("org.testcontainers:consul")
    testImplementation("org.testcontainers:elasticsearch")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:kafka")
    testImplementation("org.testcontainers:postgresql")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
