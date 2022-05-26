package com.example.myapplication

object SmileIdentificator {
    private var id = 0
    fun getAndIncrement() = id++
    fun get() = id
}