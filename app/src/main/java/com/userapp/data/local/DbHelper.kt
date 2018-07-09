package com.userapp.data.local

import com.userapp.data.User
import io.reactivex.Flowable

/**
 * Created on 7/8/18.
 */
interface DbHelper {

    fun insertUser(user: User?)

    fun selectUsers(): Flowable<MutableList<User>>

    fun selectUserByEmail(email: String): MutableList<User>

    fun deleteUser(user: User?)
}