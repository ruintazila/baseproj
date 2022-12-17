@file:Suppress("UnstableApiUsage")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("./local-repo/") }
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "io.github.ruintazila.dm-plugin" -> {
                    useModule("io.github.ruintazila:dm-plugin:${requested.version}")
                }
            }
        }
    }
}

val snapshotVersion : String? = System.getenv("COMPOSE_SNAPSHOT_ID")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        snapshotVersion?.let {
            println("https://androidx.dev/snapshots/builds/$it/artifacts/repository/")
            maven { url = uri("https://androidx.dev/snapshots/builds/$it/artifacts/repository/") }
        }
        mavenCentral()
        google()
        maven { setUrl("https://jitpack.io") }
    }
    versionCatalogs {
        create("libs") {
            from(files("${rootDir.path}/.config/libs.versions.toml"))
        }
    }
}
rootProject.name = "core-lib"
include(":app")
includeBuild("plugins")
