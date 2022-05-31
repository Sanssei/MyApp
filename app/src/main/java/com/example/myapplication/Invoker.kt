package com.example.myapplication

import java.util.*
import javax.inject.Inject

class Invoker @Inject constructor() {
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