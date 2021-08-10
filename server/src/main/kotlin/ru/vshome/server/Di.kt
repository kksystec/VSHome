package ru.vshome.server

import org.kodein.di.*
import ru.vshome.server.domain.DebugInteractor
import ru.vshome.server.domain.DebugInteractorImpl
import ru.vshome.server.web.WebServer
import ru.vshome.server.web.WebServerImpl


val Kodein = DI.lazy {
//    import(Di.cameraFeatureModule())
//
//    // Repository
//    bind<DatabaseFactory>() with singleton(ref = weakReference) { DatabaseFactoryImpl() }
//    bind<Database>() with singleton { i<DatabaseFactory>().createDatabase() }
//    bind<UserRepository>() with singleton { UserRepositoryImpl(i()) }
//    bind<ConfigurationRepository>() with singleton { ConfigurationRepositoryImpl() }
//
    bind<WebServer>() with singleton { WebServerImpl(allInstances(), allInstances()) }
//
//    // Configurations
//    bind<AuthenticationConfiguration>() with singleton(ref = weakReference) { AuthenticationConfigurationImpl() }
//    bind<ContentNegotiationConfiguration>() with singleton(ref = weakReference) { ContentNegotiationConfigurationImpl() }
//    bind<GraphQLConfiguration>() with singleton(ref = weakReference) { GraphQLConfigurationImpl(allInstances()) }
//    bind<StaticResourcesConfiguration>() with singleton(ref = weakReference) { StaticResourcesConfigurationImpl() }
//    bind<StatusPagesConfiguration>() with singleton(ref = weakReference) { StatusPagesConfigurationImpl() }
//    bind<TestRoutesConfiguration>() with singleton(ref = weakReference) { TestRoutesConfigurationImpl() }
//    bind<WebServerConnectionConfiguration>() with singleton(ref = weakReference) { WebServerConnectionConfigurationImpl(i()) }
//
    // Interactors
    bind<DebugInteractor>() with singleton { DebugInteractorImpl() }
//    bind<ConfigurationInteractor>() with singleton { ConfigurationInteractorImpl(i()) }
//    bind<WebServerConnectionInteractor>() with singleton { WebServerConnectionInteractorImpl(i()) }
//    bind<UserInteractor>() with singleton { UserInteractorImpl(i()) }
//
//    // Api
//    bind<UserApi>() with singleton { UserApiImpl(i()) }
}

private inline fun <reified T : Any> DirectDIAware.i(tag: Any? = null): T = instance(tag)
