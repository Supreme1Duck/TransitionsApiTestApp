buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.0-alpha06")
    }
}

tasks.register("clean", Delete::class){
    delete (rootProject.buildDir)
}