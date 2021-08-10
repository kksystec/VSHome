package ru.vshome.server

import org.kodein.di.DI


val Kodein = DI.lazy {
//    import(Di.cameraFeatureModule())
//
//    // Repository
//    bind<DatabaseFactory>() with singleton(ref = weakReference) { DatabaseFactoryImpl() }
//    bind<Database>() with singleton { i<DatabaseFactory>().createDatabase() }
//    bind<UserRepository>() with singleton { UserRepositoryImpl(i()) }
//    bind<ConfigurationRepository>() with singleton { ConfigurationRepositoryImpl() }
//
//    bind<WebServer>() with singleton { WebServerImpl(allInstances(), allInstances()) }
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
//    // Interactors
//    bind<ConfigurationInteractor>() with singleton { ConfigurationInteractorImpl(i()) }
//    bind<DebugInteractor>() with singleton { DebugInteractorImpl(i()) }
//    bind<WebServerConnectionInteractor>() with singleton { WebServerConnectionInteractorImpl(i()) }
//    bind<UserInteractor>() with singleton { UserInteractorImpl(i()) }
//
//    // Api
//    bind<UserApi>() with singleton { UserApiImpl(i()) }
}
