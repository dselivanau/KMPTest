package com.example.kmptestapp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

interface Bindable<T : Any?> {
    fun bind(consumer: (T) -> Unit): Cancelable
}

open class BindableFlow<T : Any?>(
    private val flow: Flow<T>,
) : Bindable<T> {

    override fun bind(consumer: (T) -> Unit): Cancelable {
        val job = Job()
        flow.onEach { consumer(it) }.launchIn(CoroutineScope(Dispatchers.Main + job))
        return object : Cancelable {
            override fun cancel() {
                job.cancel()
            }
        }
    }
}

interface Cancelable {
    fun cancel()
}