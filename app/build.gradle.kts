plugins {
    id(Plugins.androidApp)
    kotlin("android")
    id(Plugins.daggerHilt)
    id(Plugins.kotlinKapt)
}

android {
    namespace = "com.example.contacts"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            enableUnitTestCoverage = false
            enableAndroidTestCoverage = false
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.KotlinX.kotlinCompilerExtension
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

dependencies {


    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)

    implementation(Dependencies.Compose.composeUI)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.activityCompose)
    debugImplementation(Dependencies.Compose.uiTooling)
    debugImplementation(Dependencies.Compose.uiTestManifest)
    implementation(Dependencies.Compose.composeNavigation)
    implementation(Dependencies.Compose.materialIcons)

    implementation(Dependencies.DaggerHilt.hilt)
    implementation(Dependencies.DaggerHilt.hiltNavigation)
    kapt(Dependencies.DaggerHilt.hiltAndroidCompiler)
    kaptAndroidTest(Dependencies.DaggerHilt.kaptHiltAndroidCompiler)

    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.material3WindowSizeClass)

    implementation(Dependencies.KotlinX.kotlinxCoroutinesAndroid)
    implementation(Dependencies.KotlinX.kotlinxCoroutinesPlayServices)

    implementation(Dependencies.Room.room)
    kapt(Dependencies.Room.roomCompiler)
    implementation(Dependencies.Room.roomKtx)

    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.testJunit)
    androidTestImplementation(Dependencies.Testing.espressoCore)
    androidTestImplementation(Dependencies.Testing.uiTestJunit)
    testImplementation(Dependencies.Testing.truth)
    testImplementation(Dependencies.Testing.kotlinCoroutinesTest)
    testImplementation(Dependencies.Testing.archCoreTest)
    testImplementation(Dependencies.Testing.turbine)
    testImplementation(Dependencies.Testing.mockk)
    testImplementation(Dependencies.Testing.mockkAgent)
    androidTestImplementation(Dependencies.Testing.navigationTest)
    androidTestImplementation(Dependencies.Testing.hiltAndroidTesting)

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
}