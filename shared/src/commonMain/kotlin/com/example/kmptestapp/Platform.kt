package com.example.kmptestapp

interface Platform {
    val name: String
    val secondName: String
}

expect fun getPlatform(): Platform
fun testFuncNotExteptec(): String {
    return "HE-HE-HE"
}