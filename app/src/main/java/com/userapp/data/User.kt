package com.userapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created on 7/7/18.
 */

@Entity(tableName = "users")
data class User(
        @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString(),
        var name: String,
        var email: String,
        var phone: String,
        var password: String
) {

    fun isEmailCorrect(email: String) : Boolean {
        return true
    }

    override fun toString() = name
}