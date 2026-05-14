import java.awt.GraphicsEnvironment
import javax.swing.ImageIcon
import javax.swing.JOptionPane
import javax.swing.JPasswordField
import javax.swing.SwingUtilities

plugins {
    alias(libs.plugins.javalib)
    alias(libs.plugins.eclipse)
    alias(libs.plugins.idea)
    alias(libs.plugins.moddevgradle)
    alias(libs.plugins.publisher)
    alias(libs.plugins.mcSafeResources)
}

val mod_version: String by project
val mod_group_id: String by project
val mod_id: String by project
val minecraft_version: String by project
val neoforge_version: String by project
val epicfight_version: String by project
val epicskills_version: String by project

val minecraft_version_range: String by project
val forge_version_range: String by project
val loader_version_range: String by project
val mod_name: String by project
val mod_license: String by project
val mod_authors: String by project
val mod_description: String by project

val modPascalCase: String = mod_id.split('_').joinToString("") { it.replaceFirstChar { char -> char.uppercase() } }


repositories {
    fun RepositoryHandler.strictMaven(url: String, repoName: String? = null, vararg groups: String) {
        exclusiveContent {
            forRepository {
                maven(url) {
                    if (repoName != null) name = repoName
                }
            }
            filter {
                groups.forEach { includeGroupAndSubgroups(it) }
            }
        }
    }

    strictMaven("https://cursemaven.com", "Curse Maven", "curse.maven")
    strictMaven("https://api.modrinth.com/maven", "Modrinth","maven.modrinth")


    flatDir {
        dir("./libs")
    }

    mavenCentral()
}

mcSafeResources {
    namespace.set(mod_id)
    outputPackage.set("yesman.${mod_id}.generated")
}

base {
    archivesName = mod_id
    version = mod_version
}

java.sourceSets.main.get().java.srcDirs(
    tasks.generateLangKeys.map { it.outputs.files.singleFile },
    tasks.generateSoundKeys.map { it.outputs.files.singleFile }
)


java.toolchain.languageVersion = JavaLanguageVersion.of(21)

neoForge {
    version = neoforge_version
    runs {
        create("client") {
            client()
            devLogin.set(true)
            systemProperty("neoforge.enabledGameTestNamespaces", mod_id)
        }

        create("clientNoAuth") {
            client()
            systemProperty("neoforge.enabledGameTestNamespaces", mod_id)
        }

        create("server") {
            server()
            systemProperty("neoforge.enabledGameTestNamespaces", mod_id)
        }

        configureEach {
            systemProperty("forge.logging.markers", "REGISTRIES")
            logLevel = org.slf4j.event.Level.DEBUG
        }
    }

    mods {
        register(mod_id) {
            sourceSet(sourceSets.main.get())
        }
    }
}

sourceSets.main {
    resources.srcDir(layout.projectDirectory.dir("src/generated/resources"))
}


dependencies {
    runtimeOnly("maven.modrinth:ldlib:mc1.21.1-2.2.4.a-neoforge")
    implementation(libs.epicFightTest)
    runtimeOnly(libs.moonlight)
    runtimeOnly(libs.dummy)
    implementation(libs.epicskills)
    implementation(libs.battleArtsAPI)
    implementation("maven.modrinth:photon-editor:mc1.21.1-2.1.4-neoforge")
}

///Advanced
tasks.register<Jar>("signJar") {
    group = "build"
    description = "Signs the mod JAR securely using a YubiKey GUI prompt."

    val jarTask = tasks.named<Jar>("jar")
    dependsOn(jarTask)

    val jarFileProvider = jarTask.flatMap { it.archiveFile }

    val configPath = layout.projectDirectory.file("yubikey.conf").asFile.absolutePath
    val aliasName = project.findProperty("yubiAlias")?.toString() ?: "X.509 Certificate for Digital Signature"

    doLast {
        val jarFile = jarFileProvider.get().asFile

        if (GraphicsEnvironment.isHeadless()) {
            throw GradleException("Headless environment detected. A GUI is required to prompt for the PIN.")
        }

        val pf = JPasswordField()
        var result = JOptionPane.CANCEL_OPTION

        SwingUtilities.invokeAndWait {

            val iconFile = layout.projectDirectory.file("icon.png").asFile
            val customIcon = if (iconFile.exists()) ImageIcon(iconFile.absolutePath) else null

            val pane = JOptionPane(pf, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION)
            val dialog = pane.createDialog("Enter YubiKey PIN")

            if (customIcon != null) dialog.setIconImage(customIcon.image)

            dialog.isAlwaysOnTop = true
            dialog.isVisible = true
            result = (pane.value as? Int) ?: JOptionPane.CANCEL_OPTION
        }

        if (result != JOptionPane.OK_OPTION) {
            println("JAR signing skipped")
        }
        else
        {
            val pin = String(pf.password)
            if (pin.isEmpty()) {
                throw GradleException("PIN cannot be empty.")
            }

            println("--------------------------------------------------")
            println("Signing JAR: ${jarFile.name}")
            println("Please TOUCH the gold contact when your YubiKey flashes.")
            println("--------------------------------------------------")

            val process = ProcessBuilder(
                "jarsigner",
                "-keystore", "NONE",
                "-storetype", "PKCS11",
                "-providerClass", "sun.security.pkcs11.SunPKCS11",
                "-providerArg", configPath,
                "-storepass", pin,
                "-tsa", "http://timestamp.digicert.com",
                jarFile.absolutePath,
                aliasName
            ).inheritIO().start()

            val exitCode = process.waitFor()
            if (exitCode != 0) {
                throw GradleException("jarsigner failed with exit code $exitCode")
            }

            println("Success! JAR signed.")
        }
    }
}

val generateModMetadata = tasks.register<ProcessResources>("generateModMetadata") {
    val replaceProperties = mapOf(
        "minecraft_version"       to minecraft_version,
        "minecraft_version_range" to minecraft_version_range,
        "neo_version"            to neoforge_version,
        "neo_version_range"      to forge_version_range,
        "loader_version_range"   to loader_version_range,
        "mod_id"                 to mod_id,
        "mod_name"               to mod_name,
        "mod_license"            to mod_license,
        "mod_version"            to mod_version,
        "mod_authors"            to mod_authors,
        "mod_description"        to mod_description
    )

    inputs.properties(replaceProperties)
    expand(replaceProperties)

    from("src/main/templates")
    into("build/generated/sources/modMetadata")
}

sourceSets.main.get().resources.srcDir(generateModMetadata)

val TaskContainer.jar: TaskProvider<Jar>
    get() = named<Jar>("jar")

tasks.named("publishMods") {
    dependsOn(tasks.named("signJar"))
}

publishMods {

    file.set(tasks.named<Jar>("signJar").flatMap { it.archiveFile })
    changelog.set(file("changelog.md").readText())
    type.set(me.modmuss50.mpp.ReleaseType.ALPHA)
    modLoaders.add("neoforge")

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

