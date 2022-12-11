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
}
/*    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "dagger.hilt.android.plugin" -> {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:${requested.version}")
                }
                "io.github.ruintazila.dm-plugin" -> {
                    useModule("com.github.ruintazila.dm-plugin:dm-plugin:${requested.version}")
                }
            }
        }
    }*/
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
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
