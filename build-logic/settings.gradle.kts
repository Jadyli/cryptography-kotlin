/*
 * Copyright (c) 2023-2024 Oleg Yukhnevich. Use of this source code is governed by the Apache 2.0 license.
 */

pluginManagement {
    includeBuild("../build-settings")
//    includeBuild("../testtool")
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
    }
    versionCatalogs.named("libs") {
        from(files("../gradle/libs.versions.toml"))
    }
}

rootProject.name = "build-logic"
