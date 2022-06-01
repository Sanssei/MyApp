package com.example.myapplication

import java.util.*

class Invoker {
    val stackCommand = Stack<Command>()
    fun execute(command: Command) {
        command.execute()
        stackCommand.add(command)
    }
    fun unDo () {
        if (stackCommand.isNotEmpty()){
            stackCommand.peek().unDo()
            stackCommand.pop()
        }
    }
}