package com.example.repository.repository

import com.example.repository.repository.local.preference.AuthPref
import com.example.repository.repository.mapper.UserMapper
import com.example.repository.repository.remote.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthRepository(private val authPrefs: AuthPref) {

    fun getUserName() = authPrefs.user?.name

    fun getUser() = authPrefs.user

    fun isLoggedIn(): Boolean {
        val a = authPrefs.user?.email
        return a != null
    }

    fun logout() = authPrefs.logout()

    fun loginWithEmail(iname: String,iemail: String, ipassword: String) = flow {
        emit(Resource.Loading)
        try {
            authPrefs.user = UserMapper.toUser(iname,iemail,ipassword)
            emit(Resource.SuccessNothing)
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}