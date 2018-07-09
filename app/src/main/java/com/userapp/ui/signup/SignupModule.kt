package com.userapp.ui.signup

import dagger.Module
import dagger.Provides

/**
 * Created on 7/8/18.
 */
@Module
class SignupModule {

    @Provides
    fun providesSignupPresenter(presenter: SignupPresenter): SignupContract.Presenter {
        return presenter
    }
}