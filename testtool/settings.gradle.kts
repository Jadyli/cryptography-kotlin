/*
 * Copyright (c) 2023-2024 Oleg Yukhnevich. Use of this source code is governed by the Apache 2.0 license.
 */

import cksettings.*

pluginManagement {
    includeBuild("../build-settings")
    repositories {
        mavenLocal()
        maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
        maven("https://mirrors.tencent.com/nexus/repository/maven-public")
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("cksettings.default")
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven("https://mirrors.tencent.com/nexus/repository/maven-tencent")
        maven("https://mirrors.tencent.com/nexus/repository/maven-public")
        mavenCentral()
    }
    versionCatalogs.named("libs") {
        from(files("../gradle/libs.versions.toml"))
    }
}

projects("testtool") {
    module("client")
    module("server")
    module("plugin")
}
