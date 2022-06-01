package com.example.myapplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [SmileModule::class]
)

interface SmileComponent {

    // Activities
    fun inject(activity: MainActivity)
}