@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
//    id("com.android.application")
//    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
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

dependencies {

}