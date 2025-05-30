package org.example.properties

class LazyProperty(private val initializer: () -> Int) {
    val lazyValue: Int by lazy(initializer)
}