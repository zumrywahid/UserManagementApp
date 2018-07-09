package com.userapp.ui

/**
 * Created on 7/7/18.
 */
interface BaseView<T> {

    fun showMessage(message: String)

    fun showError(message: String)
}