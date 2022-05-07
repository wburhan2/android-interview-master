plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.kapt")
}

val composeVersion = "1.1.0-rc01"
val composeCompilerVersion = "1.1.0-rc02"

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.goat.android.weather"
    minSdk = 24
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildFeatures {
    compose = true
    dataBinding = true
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  composeOptions {
    kotlinCompilerExtensionVersion = composeCompilerVersion
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation("androidx.activity:activity-compose:1.4.0")
  implementation("androidx.compose.compiler:compiler:$composeCompilerVersion")
  implementation("androidx.compose.animation:animation:$composeVersion")
  implementation("androidx.compose.material:material:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling:$composeVersion")
  implementation("com.squareup.okhttp3:okhttp:4.9.3")
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
  implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
  kapt("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")

  implementation("androidx.core:core-ktx:1.7.0")
  implementation("androidx.appcompat:appcompat:1.4.1")
  implementation("com.google.android.material:material:1.5.0")
  implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
  implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}