plugins {
    kotlin("jvm") version "1.9.25"
    id("java-library")
    id("maven-publish")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.itpark"
version = "0.0.1"
description = "chat-events-contracts"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

publishing {

    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/bibamet/event-contracts")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation ("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly ("org.junit.platform:junit-platform-launcher")
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
