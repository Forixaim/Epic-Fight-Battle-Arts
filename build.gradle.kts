plugins {
    alias(libs.plugins.eclipse)
    alias(libs.plugins.idea)
    alias(libs.plugins.moddevgradle)
    alias(libs.plugins.publisher)
    alias(libs.plugins.mcSafeResources)
}

val mod_group_id: String by project
val mod_version: String by project
val mod_id: String by project
val minecraft_version: String by project
val forge_version: String by project
val parchment_version: String by project

val minecraft_version_range: String by project
val forge_version_range: String by project
val loader_version_range: String by project
val mod_name: String by project
val mod_license: String by project
val mod_authors: String by project
val mod_description: String by project

group = mod_group_id
version = mod_version

val modPascalCase: String = mod_id.split('_').joinToString("") { it.replaceFirstChar { char -> char.uppercase() } }

base {
    archivesName.set(modPascalCase)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

legacyForge {
    version = ("$minecraft_version-$forge_version")
    accessTransformers.from(file("src/main/resources/META-INF/accesstransformer.cfg"))

    parchment {
        mappingsVersion.set(parchment_version)
        minecraftVersion.set(minecraft_version)
    }

    runs {

        create("clientProduction")
        {
            client()
            systemProperty("net.minecraftforge.gradle.GradleStart.srg.srg-mcp", "false")
            devLogin.set(true)
        }

        create("client") {
            client()
            devLogin.set(true)
            systemProperty("forge.logging.markers", "REGISTRIES")
            systemProperty("forge.logging.console.level", "debug")
            systemProperty("forge.enabledGameTestNamespaces", mod_id)
        }

        create("clientNoAuth") {
            client()
            systemProperty("forge.logging.markers", "REGISTRIES")
            systemProperty("forge.logging.console.level", "debug")
            systemProperty("forge.enabledGameTestNamespaces", mod_id)
        }

        create("server") {
            server()
            systemProperty("forge.logging.markers", "REGISTRIES")
            systemProperty("forge.logging.console.level", "debug")
            systemProperty("forge.enabledGameTestNamespaces", mod_id)
        }

        create("data") {
            data()
            systemProperty("forge.logging.markers", "REGISTRIES")
            systemProperty("forge.logging.console.level", "debug")
            systemProperty("forge.enabledGameTestNamespaces", mod_id)
        }
    }

    mods {
        create(mod_id) {
            sourceSet(sourceSets.main.get())
        }
    }


}

sourceSets.main {
    resources {
        srcDir("src/generated/resources")
    }
}

repositories {
    fun RepositoryHandler.strictMaven(url: String, vararg groups: String) {
        exclusiveContent {
            forRepository { maven(url) }
            filter {
                groups.forEach { includeGroupAndSubgroups(it) }
            }
        }
    }
    strictMaven("https://cursemaven.com", "curse.maven")
    strictMaven("https://api.modrinth.com/maven", "maven.modrinth")

    flatDir {
        dir("./libs")
    }
    mavenCentral()
}

dependencies {
    //Highly recommend a version catalog
    modRuntimeOnly(libs.embeddium)
    modImplementation(libs.battleArtsAPI)
    modCompileOnly(libs.mekanism)
    modCompileOnly(libs.draconicEvolution)
    modCompileOnly(libs.projecte)
    modImplementation(libs.epicFight)
    modCompileOnly(libs.mmmmmmmmmmmm)
    modRuntimeOnly(libs.epicFightExtra)
    modRuntimeOnly(libs.invincible)
    modImplementation(libs.exCapExtra)
}

tasks.named<ProcessResources>("processResources").configure {
    val replaceProperties = mapOf(
            "minecraft_version" to minecraft_version,
            "minecraft_version_range" to minecraft_version_range,
            "forge_version" to forge_version,
            "forge_version_range" to forge_version_range,
            "loader_version_range" to loader_version_range,
            "mod_id" to mod_id,
            "mod_name" to mod_name,
            "mod_license" to mod_license,
            "mod_version" to mod_version,
            "mod_authors" to mod_authors,
            "mod_description" to mod_description
    )

    inputs.properties(replaceProperties)

    filesMatching(listOf("META-INF/mods.toml", "pack.mcmeta")) {
        expand(replaceProperties + mapOf("project" to project))
    }
}



tasks.named<Jar>("jar").configure {
    finalizedBy(tasks.named("reobfJar"))
}

val TaskContainer.jar: TaskProvider<Jar>
    get() = named<Jar>("jar")

publishMods {
    file.set(tasks.named<Jar>("reobfJar").flatMap { it.archiveFile })
    changelog.set(file("changelog.md").readText())
    type.set(me.modmuss50.mpp.ReleaseType.STABLE)
    modLoaders.add("forge")

    curseforge {
        projectId.set("933502")
        projectSlug.set("battle-arts")
        accessToken.set(providers.environmentVariable("CURSEFORGE_TOKEN"))
        minecraftVersions.add(minecraft_version)

        javaVersions.add(JavaVersion.VERSION_17)

        clientRequired.set(true)
        serverRequired.set(true)
    }

    modrinth {
        projectId.set("Dd6vT4jF")
        accessToken.set(providers.environmentVariable("MODRINTH_TOKEN"))
        minecraftVersions.add(minecraft_version)
        requires("epic-fight")
    }

    discord {
        username.set("Battle Artist")
        webhookUrl.set(providers.environmentVariable("BATTLE_ARTS_DISCORD_URL"))
        avatarUrl.set("https://cdn.discordapp.com/attachments/1404959979496013894/1487715037689810945/Acid.png?ex=69ca2619&is=69c8d499&hm=22ccf65d8fee84a316d829f1f063cb45c1f53918f1b4b2fda653c3ab7203d094&")
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}