object Dependencies {

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.AndroidX.coreKtxVersion}"
        const val lifecycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycleRuntimeKtxVersion}"
        const val lifecycleRuntimeCompose =
            "androidx.lifecycle:lifecycle-runtime-compose:${Versions.AndroidX.lifecycleRuntimeComposeVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompatVersion}"

    }

    object Compose {
        const val composeUI = "androidx.compose.ui:ui:${Versions.AndroidX.composeVersion}"
        const val material =
            "androidx.compose.material:material:${Versions.AndroidX.composeVersion}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.AndroidX.composeVersion}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Versions.AndroidX.activityComposeVersion}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.AndroidX.composeVersion}"
        const val uiTestManifest =
            "androidx.compose.ui:ui-test-manifest:${Versions.AndroidX.composeVersion}"
        const val composeNavigation =
            "androidx.navigation:navigation-compose:${Versions.AndroidX.composeNavigationVersion}"
        const val materialIcons =
            "androidx.compose.material:material-icons-extended:${Versions.AndroidX.materialIconsVersion}"

        const val material3 =
            "androidx.compose.material3:material3:${Versions.AndroidX.material3Version}"
        const val material3WindowSizeClass =
            "androidx.compose.material3:material3-window-size-class:${Versions.AndroidX.material3Version}"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.DaggerHilt.hiltVersion}"
        const val hiltNavigation =
            "androidx.hilt:hilt-navigation-compose:${Versions.DaggerHilt.hiltNavigationVersion}"
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.DaggerHilt.hiltVersion}"
        const val kaptHiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.DaggerHilt.hiltVersion}"
        const val hiltGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.DaggerHilt.hiltVersion}"
    }

    object Google {
        const val firebaseBom =
            "com.google.firebase:firebase-bom:${Versions.Google.firebaseBomVersion}"
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
        const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
        const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
        const val firebaseCrashlyticsGradle =
            "com.google.firebase:firebase-crashlytics-gradle:${Versions.Google.firebaseCrashlyticsVersion}"
        const val googleServices =
            "com.google.gms:google-services:${Versions.Google.googleServicesVersion}"
        const val googlePlayServicesAuth =
            "com.google.android.gms:play-services-auth:${Versions.Google.googlePlayServicesAuthVersion}"
        const val material =
            "com.google.android.material:material:${Versions.Google.materialVersion}"
    }

    object KotlinX {
        const val kotlinxCoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KotlinX.kotlinxCoroutines}"
        const val kotlinxCoroutinesPlayServices =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.KotlinX.kotlinxCoroutines}"
    }

    object Room {
        const val roomCompiler = "androidx.room:room-compiler:${Versions.AndroidX.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.AndroidX.roomVersion}"
        const val room = "androidx.room:room-common:${Versions.AndroidX.roomVersion}"
    }

    object Testing {
        const val junit = "junit:junit:${Versions.Testing.junitVersion}"
        const val testJunit = "androidx.test.ext:junit:${Versions.Testing.testJunitVersion}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.Testing.espressoCoreVersion}"
        const val uiTestJunit =
            "androidx.compose.ui:ui-test-junit4:${Versions.AndroidX.composeVersion}"
        const val truth = "com.google.truth:truth:${Versions.Testing.truthVersion}"
        const val kotlinCoroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Testing.kotlinxCoroutinesTest}"
        const val archCoreTest =
            "androidx.arch.core:core-testing:${Versions.Testing.archCoreTestingVersion}"
        const val turbine = "app.cash.turbine:turbine:${Versions.Testing.turbineVersion}"
        const val mockk = "io.mockk:mockk:${Versions.Testing.mockkVersion}"
        const val mockkAgent = "io.mockk:mockk-agent-jvm:${Versions.Testing.mockkVersion}"
        const val navigationTest =
            "androidx.navigation:navigation-testing:${Versions.AndroidX.composeNavigationVersion}"
        const val hiltAndroidTesting =
            "com.google.dagger:hilt-android-testing:${Versions.DaggerHilt.hiltVersion}"
        const val jacoco = "org.jacoco:org.jacoco.core:${Versions.Testing.jacocoVersion}"
    }
}