package com.userapp.di.Modules

import android.app.Application
import android.content.Context
import com.userapp.common.UserApplication
import com.userapp.data.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created on 7/8/18.
 */
@Module
class ApplicationModule {

    //expose Application as an injectable context
    @Provides
    fun bindContext(application: Application): Context {
        return application
    }

}
