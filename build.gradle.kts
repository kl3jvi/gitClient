import Deps.hiltGradlePlugin
import Deps.safeNavigation
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(Deps.safeNavigation)

        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }

}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

subprojects {

    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }
}

// JVM target applied to all Kotlin tasks across all sub-projects
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

