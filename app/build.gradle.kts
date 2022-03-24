plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.kl3jvi.payconiq"
        minSdk = (ConfigData.minSdkVersion)
        targetSdk = (ConfigData.targetSdkVersion)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(Deps.androidxLegacy)
    implementation(Deps.navRuntime)
    implementation(Deps.navFragment)
    implementation(Deps.navUi)
    implementation(Deps.androidCore)
    implementation(Deps.appCompat)
    implementation(Deps.material)
    implementation(Deps.constraintLayout)
    implementation(Deps.viewModel)
    implementation(Deps.fragmentKtx)
    implementation(Deps.lifecycleRuntime)
    implementation(Deps.coroutinesAndroid)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitInterceptor)
    implementation(Deps.moshiConverter)
    implementation(Deps.coroutinesCore)

    implementation(Deps.moshiKotlin)
    kapt(Deps.moshiKapt)


    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)

    implementation(Deps.room)
    implementation(Deps.roomKtx)
    kapt(Deps.roomKapt)

    implementation(Deps.coil)

    implementation(Deps.splashScreenVersion)
    implementation(Deps.palette)

    testImplementation(Deps.junit)
    testImplementation(Deps.mockitoCore)
    testImplementation(Deps.mockitoKtx)
    testImplementation(Deps.googleTruth)
    testImplementation(Deps.androidXTesting)
    testImplementation(Deps.coreTesting)

}
