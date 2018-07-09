package com.userapp.ui.login

import com.userapp.ui.BasePresenter
import com.userapp.ui.BaseView

/**
 * Created on 7/7/18.
 */
interface LoginContract {

    interface Presenter: BasePresenter<View> {
        fun loginUser(username: String, password: String): Boolean
    }

    interface View: BaseView<Presenter> {
        fun setLoadingIndicator()
        fun hideLoadingIndicator()
        fun showLoginResult(isSuccess: Boolean)
    }
}