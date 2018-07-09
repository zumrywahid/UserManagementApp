package com.userapp.ui.login

import dagger.Module
import dagger.Provides

/**
 * Created on 7/8/18.
 */
@Module
class LoginModule {

    @Provides
    fun providesLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter {
        return presenter
    }
}