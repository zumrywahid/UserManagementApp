package com.userapp.data.local

import com.userapp.data.User
import com.userapp.data.UserDataManager
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created on 7/8/18.
 */
class UserLocalDataSource @Inject constructor(private val appDatabase: AppDatabase): DbHelper {
    override fun insertUser(user: User?) {
        appDatabase.userDao().insertRecipe(user)
    }

    override fun selectUsers(): Flowable<MutableList<User>> {
        return appDatabase.userDao().getAllUsers()
    }

    override fun selectUserByEmail(email: String): MutableList<User> {
        return appDatabase.userDao().getUserByEmail(email)
    }

    override fun deleteUser(user: User?) {
        appDatabase.userDao().deleteRecipe(user)
    }

}