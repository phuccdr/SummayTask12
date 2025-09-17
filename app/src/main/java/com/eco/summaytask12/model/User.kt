package com.eco.summaytask12.model

import com.eco.summaytask12.util.normalizeUserName
import java.util.UUID

open class User {
    var id: String? = UUID.randomUUID().toString()
    var userName: String? = null
    var email: String? = null
    var password: String? = null
    var gender: String? = null
    var dateOfBirth: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var phone: String? = null
    var address: String? = null
    var status: StatusUser? = null


    fun login(userName: String, password: String): Boolean {
        if (this.userName.equals(userName.normalizeUserName()) && this.password.equals(password)) {
            this.status = StatusUser.ACTIVE
            return true
        } else {
            return false
        }
    }

    fun logout(): Boolean {
        this.status = StatusUser.INACTIVE
        return true
    }

    fun changePassword(oldPassword: String, newPassword: String): Boolean {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword
            return true
        } else {
            return false
        }
    }

    fun updateUserName(userName: String): Boolean {
        this.userName = userName
        return true
    }

}