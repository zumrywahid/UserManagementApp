package com.userapp.common

import android.support.annotation.VisibleForTesting
import com.userapp.data.User
import com.userapp.data.UserRepository
import com.userapp.di.Components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


/**
 * Created on 7/7/18.
 */

class UserApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

//    @Inject
//    @get:VisibleForTesting
//    var userRepository: UserRepository? = null
//        internal set

}