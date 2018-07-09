package com.userapp.ui

/**
 * Created on 7/7/18.
 */
interface BasePresenter<T> {

    abstract fun takeView(view: T)

    abstract fun dropView()
}