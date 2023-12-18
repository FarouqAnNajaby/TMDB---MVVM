package com.example.repository.repository.mapper

import com.example.repository.repository.local.model.User

object UserMapper {
    fun toUser(iname: String,iemail: String, ipassword: String) : User {
        return User().apply {
            password = ipassword
            email = iemail
            name = iname
        }
    }
}