plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.gamestreampriject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.gamestreampriject"
        minSdk = 23
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding.enable = true
    dataBinding.enable = true




}


dependencies {
    //libr
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0-RC")
    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.6.2")
    //Adapter Delegates
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl:4.3.2")
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:4.3.2")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.8.1")
    //GsonConverter
    implementation("com.squareup.retrofit2:converter-gson:2.8.1")
    //Sync module
    implementation(project(":core-network")) //TODO remove
    //Glide
    implementation( "com.github.bumptech.glide:glide:4.16.0")

    //tests
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}