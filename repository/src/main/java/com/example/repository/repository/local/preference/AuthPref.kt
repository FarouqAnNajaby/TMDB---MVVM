package com.example.repository.repository.local.preference

import com.chibatching.kotpref.KotprefModel
import com.chibatching.kotpref.gsonpref.gsonNullablePref
import com.example.repository.repository.local.model.User

object AuthPref : KotprefModel(){

    var user by gsonNullablePref<User>()

    fun logout(){
        clear()
    }
}