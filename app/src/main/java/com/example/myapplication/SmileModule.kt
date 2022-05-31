package com.example.myapplication

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SmileModule {
    @Provides
    @Singleton
    fun provideSmileAdapter() = SmileAdapter()
}