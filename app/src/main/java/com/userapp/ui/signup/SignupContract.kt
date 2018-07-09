package com.userapp.ui.signup

import com.userapp.data.User
import com.userapp.ui.BasePresenter
import com.userapp.ui.BaseView

/**
 * Created on 7/8/18.
 */
interface SignupContract {
    interface Presenter: BasePresenter<View> {
        fun signupUser(user: User)
        fun validateEmail(email: String)
        fun validatePhoneNumber(phone: String): Boolean
    }

    interface View: BaseView<Presenter> {
        fun setLoadingIndicator()
        fun hideLoadingIndicator()
        fun updateSignup(isSuccess: Boolean)
        fun afterEmailValidation(isSuccess: Boolean)
    }
}