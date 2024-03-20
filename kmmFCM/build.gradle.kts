plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "KMM FCM CoCoapods"
        homepage = ""
        version = "1.0"
        ios.deploymentTarget = "15.0"
        framework {
            baseName = "kmmFCM"
            isStatic = true
        }
        pod("FirebaseMessaging") {
            version = "10.18"
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:32.7.4"))
            implementation("com.google.firebase:firebase-messaging-ktx")
        }
    }
}

android {
    namespace = "com.wonddak.kmmnoti"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}