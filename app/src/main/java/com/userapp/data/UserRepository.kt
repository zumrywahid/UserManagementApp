package com.userapp.data

import com.userapp.data.local.UserLocalDataSource
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created on 7/7/18.
 */
class UserRepository @Inject constructor(val localDataSource: UserLocalDataSource): UserDataManager {
    override fun insertUser(user: User?) {
        localDataSource.insertUser(user)
    }

    override fun selectUsers(): Flowable<MutableList<User>> {
        return localDataSource.selectUsers()
    }

    override fun selectUserByEmail(email: String): MutableList<User> {
        return localDataSource.selectUserByEmail(email)
    }

    override fun deleteUser(user: User?) {
        localDataSource.deleteUser(user)
    }
}