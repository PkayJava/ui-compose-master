/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.angkorteam.uicompose.buildsrc

object Versions {
    const val ktlint = "0.39.0"
}

object Libs {
    const val Gradle = "4.2.0-alpha13"
    const val jdkDesugar = "1.0.9"

    const val junit = "junit:junit:4.13"

    const val material = "com.google.android.material:material:1.2.1"

    object Accompanist {
        private const val version = "0.3.1"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
    }

    const val Kotlin = "1.4.10"

    object Coroutines {
        private const val version = "1.3.9"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object OkHttp {
        private const val version = "4.7.2"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Android {
        const val Material = "1.2.1"
    }

    object AndroidX {
        const val AppCompat = "1.3.0-alpha02"
        const val palette = "androidx.palette:palette:1.0.0"

        const val Core = "1.5.0-alpha04"

        const val Compose = "1.0.0-alpha06"

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2-rc01"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }

        const val Room = "2.2.5"

        object Lifecycle {
            private const val version = "2.2.0"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }
    }

    object Rome {
        private const val version = "1.14.1"
        val rome = "com.rometools:rome:$version"
        val modules = "com.rometools:rome-modules:$version"
    }
}
