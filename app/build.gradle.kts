import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.glabrion.roomsample"
    compileSdk = 33

    defaultConfig {
        applicationId = "ru.glabrion.roomsample"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Room components
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    ksp("androidx.room:room-compiler:2.5.2")

    //dagger
    implementation("com.google.dagger:dagger:2.47")
    ksp("com.google.dagger:dagger-compiler:2.47")

    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.fragment:fragment-ktx:1.6.1")


}
