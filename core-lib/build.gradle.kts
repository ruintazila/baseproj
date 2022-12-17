
// Top-level build file where you can add configuration options common to all sub-projects/modules.

//@file:Suppress("UnstableApiUsage")
//plugins {
//    id("com.android.application") version "7.3.1" apply false
//    id("com.android.library") version "7.3.1" apply false
//    id("org.jetbrains.kotlin.android") version "1.7.21" apply false
//}
@Suppress("DSL_SCOPE_VIOLATION")
ext {
    set("minSdk", libs.versions.minSdk.get())
    set("targetSdk", libs.versions.targetSdk.get())
    set("compileSdk", libs.versions.compileSdk.get())
    set("javaMajor", libs.versions.java.major.get())
    set("javaVersion", libs.versions.java.asProvider().get())
    set("composeCompiler", libs.versions.compose.compiler.get())
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dependencies.update)
    alias(libs.plugins.version.catalog.update)
}

apply("${project.rootDir}/buildscripts/toml-updater-config.gradle")
