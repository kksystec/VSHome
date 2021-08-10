package ru.vshome.config

object Configuration {
    object Versions {
        const val kotlin = "1.5.21"
//        const val kotlinSerializationJson = "1.2.1"
        const val coroutines = "1.5.0"
        const val ktor = "1.6.0"
        const val kodein = "7.6.0"
        const val log4j2 = "2.14.1"
        const val slf4j = "1.7.31"
//        const val kGraphQl = "0.17.9"
//        const val sqlDelight = "1.5.0"
//        const val kaml = "0.34.0"

        // Android
        const val androidPlugin = "7.0.0"
//        const val compose = "1.0.0-beta09"
//        const val activity = "1.3.0-beta02"

        // Js
//        private fun jsVersion(base: String) = "$base-pre.213-kotlin-$kotlin"
//        val react = jsVersion("17.0.2")
//        val reactRouter = jsVersion("5.2.0")
//        val reactRedux = jsVersion("7.2.4")
//        val redux = jsVersion("4.1.0")
//        val styled = jsVersion("5.3.0")
//        const val materialUi = "0.8.0"
    }

//    object Android {
//        const val compileSdkVersion = 30
//        const val buildToolsVersion = "30.0.3"
//        const val minSdkVersion = 26
//        const val targetSdkVersion = 30
//    }

    object Plugins {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
//        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
        const val android = "com.android.tools.build:gradle:${Versions.androidPlugin}"
//        const val sqlDelight = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
    }

    object Dependencies {
        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        }

//        object Serialization {
//            const val kotlinJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerializationJson}"
//            const val kotlinYaml = "com.charleskorn.kaml:kaml:${Versions.kaml}"
//        }

        object Ktor {
//            const val serverCore = "io.ktor:ktor-server-core:${Versions.ktor}"
//            const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
//            const val clientOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
//            const val clientJs = "io.ktor:ktor-client-js:${Versions.ktor}"
//            const val serverHostCommon = "io.ktor:ktor-server-host-common:${Versions.ktor}"
            const val netty = "io.ktor:ktor-server-netty:${Versions.ktor}"
//            const val auth = "io.ktor:ktor-auth:${Versions.ktor}"
//            const val serverSerialization = "io.ktor:ktor-serialization:${Versions.ktor}"
//            const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
//            const val certificates = "io.ktor:ktor-network-tls-certificates:${Versions.ktor}"
        }

        object Kodein {
            const val core = "org.kodein.di:kodein-di:${Versions.kodein}"
        }

//        object KGraphQL {
//            const val core = "com.apurebase:kgraphql:${Versions.kGraphQl}"
//            const val ktor = "com.apurebase:kgraphql-ktor:${Versions.kGraphQl}"
//        }

//        object SQLDelight {
//            const val sqliteDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"
//            const val coroutines = "com.squareup.sqldelight:coroutines-extensions-jvm:${Versions.sqlDelight}"
//        }

//        object Android {
//            object Compose {
//                const val ui = "androidx.compose.ui:ui:${Versions.compose}"
//                const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
//                const val material = "androidx.compose.material:material:${Versions.compose}"
//
//                const val navigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
//                const val activity = "androidx.activity:activity-compose:${Versions.activity}"
//            }
//
//            const val material = "com.google.android.material:material:1.3.0"
//        }

//        object Js {
//            object React {
//                val core = "org.jetbrains.kotlin-wrappers:kotlin-react:${Versions.react}"
//                val dom = "org.jetbrains.kotlin-wrappers:kotlin-react-dom:${Versions.react}"
//                val routerDom = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:${Versions.reactRouter}"
//                val reactRedux = "org.jetbrains.kotlin-wrappers:kotlin-react-redux:${Versions.reactRedux}"
//                val redux = "org.jetbrains.kotlin-wrappers:kotlin-redux:${Versions.redux}"
//                const val materialUi = "com.ccfraser.muirwik:muirwik-components:${Versions.materialUi}"
//            }
//
//            val styled = "org.jetbrains.kotlin-wrappers:kotlin-styled:${Versions.styled}"
//        }

        object Logging {
            const val log4j2Api = "org.apache.logging.log4j:log4j-api:${Versions.log4j2}"
            const val log4j2Core = "org.apache.logging.log4j:log4j-core:${Versions.log4j2}"
            const val log4jSlf4j = "org.apache.logging.log4j:log4j-slf4j-impl:${Versions.log4j2}"
            const val slf4j = "org.slf4j:slf4j-api:${Versions.slf4j}"
        }
    }
}
