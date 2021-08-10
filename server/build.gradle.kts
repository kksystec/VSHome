import ru.vshome.config.Configuration.Dependencies

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Kodein.core)

    implementation(Dependencies.Logging.log4j2Api)
    implementation(Dependencies.Logging.log4j2Core)
    implementation(Dependencies.Logging.log4jSlf4j)
    implementation(Dependencies.Logging.slf4j)
}