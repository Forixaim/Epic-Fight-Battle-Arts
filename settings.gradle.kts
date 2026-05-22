pluginManagement {
    repositories {
        mavenLocal()
        fun strictMaven(name: String, url: String, filter: InclusiveRepositoryContentDescriptor.() -> Unit) {
            exclusiveContent {
                forRepository { maven { this.name = name; this.url = uri(url) } }
                filter { filter() }
            }
        }

        fun strictMaven(name: String, url: String, vararg includeGroups: String) {
            strictMaven(name, url) {
                includeGroups.forEach { includeGroup(it) }
            }
        }
        gradlePluginPortal()
        strictMaven("https://maven.neoforged.net/releases", "net.neoforged")
    }

    includeBuild("gradle/build-logic")
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "Battle Arts"
