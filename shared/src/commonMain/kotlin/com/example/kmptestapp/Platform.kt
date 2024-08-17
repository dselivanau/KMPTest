package com.example.kmptestapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform