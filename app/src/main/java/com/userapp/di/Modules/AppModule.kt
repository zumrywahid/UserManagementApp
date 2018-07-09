package com.userapp.di.Modules

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.userapp.common.UserApplication
import com.userapp.data.*
import com.userapp.data.local.AppDatabase
import com.userapp.data.local.DbHelper
import com.userapp.data.local.UserLocalDataSource
import com.userapp.ui.login.LoginContract
import com.userapp.ui.login.LoginPresenter
import com.userapp.utilities.DATABASE_NAME
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


/**
 * Created on 7/7/18.
 */
@Module
public class AppModule {

    @Provides
    internal fun provideDb(context: Application): AppDatabase {
        return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
                .build()
    }

    @Provides
    fun providesLocalDataSource(localDataSource: UserLocalDataSource) : DbHelper {
        return localDataSource
    }

    @Provides
    fun providesUserRepository(repository: UserRepository) : UserDataManager {
        return repository
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}