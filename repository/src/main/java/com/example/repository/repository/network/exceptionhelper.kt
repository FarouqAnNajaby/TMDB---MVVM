package com.example.repository.repository.network

import com.example.repository.repository.remote.response.ResponseError
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.HttpException

fun Exception.getNetworkErrorBody(): ResponseError? {
    return try {
        val errorString = (this as? HttpException)?.response()?.errorBody()?.string()
        if (errorString != null) {
            val errorJson = JSONObject(errorString).optJSONObject("error")?.toString()
            Gson().fromJson(errorJson, ResponseError::class.java)
        } else {
            null
        }
    } catch (e: Exception) {
        e.message
        null
    }
}