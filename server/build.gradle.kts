import ru.vshome.config.Configuration.Dependencies

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Kodein.core)
}