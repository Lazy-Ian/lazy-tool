plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

group = "com.lazyian.tool"
version = "1.0"

android {
    namespace = "com.lazyian.tool"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
//        versionCode = 1
//        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    dataBinding {
        true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.lifecycle:lifecycle-process:2.6.2")
    implementation("androidx.databinding:databinding-runtime:8.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

//afterEvaluate
//afterEvaluate {
//    publishing {
//        publications {
//            // Creates a Maven publication called "release".
//            maven(MavenPublication) {
//                from components.release
//                        groupId = "com.github.jitpack"
//                artifactId = "android-example"
//                version = "1.0"
//            }
//        }
//    }
//}

//
//tasks.withType(JavaCompile) {
//    options.fork = true
//}
//
//
//publishing {
//    publications {
//        maven(MavenPublication) {
//            //artifact "build\\outputs\\aar\\glide-debug.aar"
//            from components.java
//                    //println components.properties
//                    //from components.wtf
//                    groupId "org.appxmod.lucene"
//            artifactId "Core"
//            version "1.0.0"
//        }
//    }
//}
//build.finalizedBy publishToMavenLocal