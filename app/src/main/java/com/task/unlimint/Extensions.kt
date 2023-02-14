package com.task.unlimint


fun <T> MutableList<T>.addToStart(element: T):MutableList<T> {
    add(0, element)
    return this
}
