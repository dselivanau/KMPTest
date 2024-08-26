package com.example.kmptestapp

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val secondName: String = "This is second name from Android"
}

actual fun getPlatform(): Platform = AndroidPlatform()