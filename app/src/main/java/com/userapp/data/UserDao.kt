package com.userapp.data

import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created on 7/7/18.
 */

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(user: User?)

    @Query("SELECT * FROM users")
    fun getAllUsers() : Flowable<MutableList<User>>

    @Query("SELECT * FROM users u where u.email = :email")
    fun getUserByEmail(email: String) : MutableList<User>

    @Query("UPDATE users SET email = :email where id = :userId")
    fun updateUserEmail(email: String, userId: String?)

    @Delete
    fun deleteRecipe(user: User?)
}