package com.example.kmptestapp

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!, ${platform.secondName}?"
    }

    fun testFun() : String {
        return testFuncNotExteptec()
    }
}