package com.goat.android.weather

/**
 * TODO: Include file description and usage here
 */
interface NetworkCallback<T> {

    fun onSuccess(response: T)

    fun onFailure(e: Throwable)
}