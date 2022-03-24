object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}


object Deps {
    val androidxLegacy by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacyVersion}" }
    val navRuntime by lazy { "androidx.navigation:navigation-runtime-ktx:${Versions.navigationComponentVersion}" }
    val navFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponentVersion}" }
    val navUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponentVersion}" }
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCoreVersion}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompatVersion}" }
    val material by lazy {
        "com.google.android.material:material:${Versions.materialVersion}"
    }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}" }

    val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}" }

    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }

    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}" }
    val retrofitInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor_version}" }

    val moshiKotlin by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.Moshi.moshiVersion}" }
    val moshiKapt by lazy { "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Moshi.moshiAnnotationProcessor}" }

    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.DI.hiltVersion}" }
    val hiltKapt by lazy { "com.google.dagger:hilt-android-compiler:${Versions.DI.hiltAnnotationProcessor}" }

    val room by lazy { "androidx.room:room-runtime:${Versions.roomVersion}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }
    val roomKapt by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }

    val coil by lazy { "io.coil-kt:coil:${Versions.coilVersion}" }
    val splashScreenVersion by lazy { "androidx.core:core-splashscreen:${Versions.splashScreenVersion}" }

    val palette by lazy { "com.android.support:palette-v7:${Versions.paletteVersion}" }
    val junit by lazy { "junit:junit:${Versions.Testing.junit}" }

    val mockitoCore by lazy { "org.mockito:mockito-core:${Versions.Testing.mockito}" }
    val mockitoKtx by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}" }

    val googleTruth by lazy { "com.google.truth:truth:${Versions.Testing.googleTruth}" }
    val androidXTesting by lazy { "androidx.test:core-ktx:${Versions.Testing.androidXTestVersion}" }
    val coreTesting by lazy { "androidx.arch.core:core-testing:${Versions.Testing.coreTestingVersion}" }

    val safeNavigation by lazy {"androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeNavArgsVersion}"}
    val hiltGradlePlugin by lazy {
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.DI.hiltGradle}"
    }
}