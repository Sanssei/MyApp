package com.example.myapplication

class InsertCommand (private val adapter: SmileAdapter,
                     private val smailFactory: SmileFactory,
                     private val id: Int) : Command {
    override fun execute() {
        adapter.addSmile(smailFactory.create(id))
    }

    override fun unDo() {
        adapter.removeSmile(smailFactory.create(id))
    }
}
