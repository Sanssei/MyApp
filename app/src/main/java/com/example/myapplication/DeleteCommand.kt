package com.example.myapplication

class DeleteCommand (private val adapter: SmileAdapter,
                     private val smailFactory: SmileFactory,
                     private val id: Int) : Command {
    override fun execute() {
        adapter.removeSmile(smailFactory.create(id))
    }

    override fun unDo() {
        adapter.addSmile(smailFactory.create(id))
    }
}