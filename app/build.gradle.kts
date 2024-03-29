plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.promi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.promi"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    val material_version = "1.11.0"
    val nav_version = "2.5.3"

    // material designs
    implementation("com.google.android.material:material:${material_version}")

    // retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson 변환기
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //material-button
    implementation("com.google.android.material:material:1.10.0")

    // viewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    // NavGraph - Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // 원형 이미지
    implementation("de.hdodenhof:circleimageview:3.1.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}