plugins {
    id("maven-publish")
    id("signing")
    kotlin("jvm") version "1.9.22"
}

group = "dev.junsung"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])
            pom {
                name.set("ProcessKt")
                description.set("ProcessKt is a versatile open-source project designed to simplify and enhance the execution of shell commands, providing a seamless experience for developers working with Kotlin. This project empowers users to effortlessly integrate and manage shell commands within their Kotlin applications, fostering efficiency and flexibility in command-line operations.")
                url.set("https://github.com/junsung-cho/ProcessKt")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/junsung-cho/ProcessKt/blob/main/LICENSE")
                    }
                }
                scm {
                    url.set("https://github.com/junsung-cho/ProcessKt.git")
                }
                developers {
                    developer {
                        id.set("junsung")
                        name.set("Junsung Cho")
                        email.set("junsung.dev@gmail.com")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            val username = System.getenv("OSSRH_USERNAME")
            val password = System.getenv("OSSRH_PASSWORD")

            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                this.username = username
                this.password = password
            }
        }
    }
}

signing {
    sign(publishing.publications)
}
