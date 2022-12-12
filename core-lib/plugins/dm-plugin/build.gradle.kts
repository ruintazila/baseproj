@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `maven-publish`
    alias(libs.plugins.gradle.publish)
}

group = "io.github.ruintazila"
version = "0.1.6"


gradlePlugin {
    plugins.register("dm-plugin") {
        id = "io.github.ruintazila.dm-plugin"
        implementationClass = "com.ruint.core.plugins.dm.DMPlugin"
        displayName = "Dependency Management Plugin for Android"
        description = "A plugin helps you to manage android extensions"
    }
}



pluginBundle {
    website = "https://github.com/ruintazila/dm-plugin"
    vcsUrl = "https://github.com/ruintazila/dm-plugin.git"
    tags = arrayListOf("android", "config")
}

publishing {
    repositories {
        maven {
            setUrl("../../local-repo")
            name = "localRepo"
        }
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
}
