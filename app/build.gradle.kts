plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pas_21_27"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pas_21_27"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit for networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Image loading libraries
    implementation("com.squareup.picasso:picasso:2.71828") // optional, kalau mau pakai Picasso
    implementation("com.github.bumptech.glide:glide:4.15.1") // Glide (lebih direkomendasikan)
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
}
