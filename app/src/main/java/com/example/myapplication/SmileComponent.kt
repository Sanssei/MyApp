package com.example.myapplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [SmileModule::class])

interface SmileComponent {
    fun getReceiver(): Receiver
    fun getAdapter(): SmileAdapter
    fun getInvoker(): Invoker
    fun getSmileFactory(): SmileFactory

    fun inject(mainActivity: MainActivity)
}