package com.example.myapplication

import javax.inject.Inject

class Receiver @Inject constructor(val invoker: Invoker,
                                   val adapter: SmileAdapter,
                private val smileFactory: SmileFactory) {
    fun add (index: Int) {
        invoker.execute(InsertCommand(adapter, smileFactory, index))
    }

    fun remove (index: Int) {
        invoker.execute(DeleteCommand(adapter, smileFactory, index))
    }
    fun unDo() {
        invoker.unDo()
    }
    val smile = SmileFactory()
}