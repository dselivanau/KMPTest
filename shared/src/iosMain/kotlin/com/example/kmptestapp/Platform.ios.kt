package com.example.kmptestapp

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val secondName: String = "This is second name from iOS"
}

actual fun getPlatform(): Platform = IOSPlatform()