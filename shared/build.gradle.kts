plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            export(libs.kotlinx.coroutines.core)
            export(libs.premo)
            export(libs.premo.navigation)
            export(libs.premo.saver.json)
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            // используй implementation когда хочешь, чтобы зависимый код не было видно за пределами модуля
            // api - для транзитивных зависимостей
            // api + export - виден код в получаемом фреймворке для ios
            api(libs.kotlinx.coroutines.core)
//            implementation(libs.navigation.compose)
//            implementation(libs.lifecycle.viewmodel.compose)
//            api(libs.premo)
            api(libs.premo.v100alpha15)
            api(libs.premo.navigation.v100alpha15)
            api(libs.premo.saver.json.v100alpha15)
            api(compose.components.resources)
        }

        androidMain.dependencies {
            implementation(libs.androidx.runtime)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
//            implementation(libs.me.premo.test)
        }
    }
}

android {
    namespace = "com.example.kmptestapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "me.sample.library.resources"
    generateResClass = always
}