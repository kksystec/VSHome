import com.github.benmanes.gradle.versions.reporter.result.Result

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ru.vshome.config.Configuration.Plugins.android)
        classpath(ru.vshome.config.Configuration.Plugins.kotlin)
    }
}

plugins {
    id("com.github.ben-manes.versions") version "0.39.0"
}

val pIsBuildAgent: String by project
tasks.dependencyUpdates.configure {
    fun isNonStable(version: String): Boolean {
        val stableKeyword =
            listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
    rejectVersionIf {
        isNonStable(candidate.version) && !isNonStable(currentVersion)
    }

    if (pIsBuildAgent.toBoolean()) {
        this.outputFormatter = closureOf<Result> {
            outdated.dependencies.forEach {
                kotlin.io.println(
                    "::warning::Library outdated: " +
                            "${it.group}:${it.name} [${it.version} -> ${it.available.milestone}]"
                )
            }
        }
    }
}

tasks.create("clean", Delete::class) {
    delete(rootProject.buildDir)
}
