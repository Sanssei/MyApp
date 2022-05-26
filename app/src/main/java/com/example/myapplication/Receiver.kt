package com.example.myapplication

class Receiver (val invoker: Invoker,
                private val adapter: SmileAdapter,
                private val smileFactory: SmailFactory) {
    fun add (index: Int) {
        invoker.execute(InsertCommand(adapter, smileFactory, index))
    }

    fun remove (index: Int) {
        invoker.execute(DeleteCommand(adapter, smileFactory, index))
    }
    fun unDo() {
        invoker.unDo()
    }
}