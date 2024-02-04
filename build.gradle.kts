plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}

buildscript {
    dependencies {
        val hiltVersion = "2.48.1"
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}