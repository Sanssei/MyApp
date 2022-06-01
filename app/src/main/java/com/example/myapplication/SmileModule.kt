package com.example.myapplication

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//InstallIn(sdfasd::class)
@Module
class SmileModule {

    @Provides
    @Singleton
    fun provideSmileAdapter() = SmileAdapter()


    @Provides
    @Singleton
    fun provideReceiver(invoker: Invoker, adapter: SmileAdapter,
                        smileFactory: SmileFactory): Receiver{
        return Receiver(invoker = invoker, adapter = adapter, smileFactory = smileFactory)
    }

    @Provides
    @Singleton
    fun provideInvoker() = Invoker()

    @Provides
    @Singleton
    fun provideSmileFactory() = SmileFactory()

//    @Binds
//    @Singleton
//    abstract fun provideSmileFactory(smileFactoryImple : SmileFactoryImple): SmileFactory


}