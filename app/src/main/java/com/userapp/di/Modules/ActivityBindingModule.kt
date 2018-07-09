package com.userapp.di.Modules

import com.userapp.data.ActivityScoped
import com.userapp.di.Modules.AppModule
import com.userapp.ui.login.LoginModule
import com.userapp.ui.signup.SignupActivity
import com.userapp.ui.signup.SignupModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import userapp.ui.home.DashboardActivity
import userapp.ui.login.LoginActivity

/**
 * Created on 7/7/18.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract fun bindDashboardActivity() : DashboardActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(LoginModule::class)])
    abstract fun bindLoginActivity() : LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SignupModule::class])
    abstract fun bindSignupActivity() : SignupActivity



}