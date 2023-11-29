import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

group = "com.abor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
    testImplementation ("com.squareup.retrofit2:retrofit:2.9.0" )
    testImplementation ("com.squareup.retrofit2:converter-gson:2.9.0" )
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5")

}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "CRIPS-TOGORH"
            packageVersion = "1.0.0"
        }
    }
}
