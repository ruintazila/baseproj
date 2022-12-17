@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dm.plugin)
}

android {
    namespace = "com.ruint.core"
    defaultConfig {
        applicationId = "com.ruint.core"
        versionCode = 1
        versionName = "goose"
    }
    splits {
        abi {
            isEnable = true
            reset()
            include("x86", "armeabi-v7a", "arm64-v8a")
            isUniversalApk = false
        }
    }
}
//apply("${project.rootDir}/buildscripts/common.gradle.kts")
dependencies {
    implementation(libs.google.android.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
}
