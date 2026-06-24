/*
 * Copyright (c) 2023-2024 Oleg Yukhnevich. Use of this source code is governed by the Apache 2.0 license.
 */

import cksettings.*

pluginManagement {
    includeBuild("build-logic")
    includeBuild("build-settings")
    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            name = "aliyun"
            url = uri("https://packages.aliyun.com/66b7f208953179b1ec5f5db8/maven/2486646-snapshot-3qr5na")
            credentials {
                username = "66b7e3a18043c5959c0c01e2"
                password = "no2udBiPX]2("
            }
        }
        maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
        maven("https://mirrors.tencent.com/nexus/repository/maven-public")
        gradlePluginPortal()
    }
}

//includeBuild("testtool")

plugins {
    id("cksettings.default")
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven {
            name = "aliyun"
            url = uri("https://packages.aliyun.com/66b7f208953179b1ec5f5db8/maven/2486646-snapshot-3qr5na")
            credentials {
                username = "66b7e3a18043c5959c0c01e2"
                password = "no2udBiPX]2("
            }
        }
        maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
        maven("https://mirrors.tencent.com/nexus/repository/maven-public")
        ivy("https://github.com/whyoleg/openssl-builds/releases/download") {
            name = "Prebuilt OpenSSL distributions"
            metadataSources { artifact() }
            content { includeGroup("ckbuild.dependencies.openssl") }
            patternLayout { artifact("[revision]/[artifact].[ext]") }
        }
    }
}

projects("cryptography-kotlin") {
    // build-tools modules
    module("cryptography-bom")
    module("cryptography-version-catalog")

    // core util modules
    module("cryptography-bigint")
    module("cryptography-random")
    folder("cryptography-serialization") {
        module("pem")
        module("asn1") {
            module("modules")
        }
    }

    // providers API, high-level API
    module("cryptography-core")

    // providers
    folder("cryptography-providers", prefix = "cryptography-provider") {
        module("base")
        module("jdk") {
//            module("android-tests")
        }
//        module("apple")
//        module("webcrypto")
        folder("openssl3") {
            module("api")
//            module("shared")
            module("prebuilt")
//            module("test")
        }
    }

    // providers tests
//    module("cryptography-providers-tests-api")
//    module("cryptography-providers-tests")
}
