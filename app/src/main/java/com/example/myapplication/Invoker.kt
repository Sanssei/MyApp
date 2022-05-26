package com.example.myapplication

class Invoker () {
    val listComand = mutableListOf<Command>()
    fun execute(command: Command) {
        command.execute()
        listComand.add(command)
    }
    fun unDo () {
        if (listComand.isNotEmpty()){
            listComand.last().unDo()
            listComand.removeLast()
        }
    }
}