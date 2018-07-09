package com.userapp.di.Components

import android.app.Application
import com.userapp.common.UserApplication
import com.userapp.di.Modules.ActivityBindingModule
import com.userapp.di.Modules.AppModule
import com.userapp.di.Modules.ApplicationModule
import com.userapp.ui.login.LoginModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created on 7/7/18.
 */
@Singleton
@Component(modules =
[
    AndroidSupportInjectionModule::class,
    ApplicationModule::class,
    AppModule::class,
    ActivityBindingModule::class
]
)
interface AppComponent: AndroidInjector<UserApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun build(): AppComponent
    }
}