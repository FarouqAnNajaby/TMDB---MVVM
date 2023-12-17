package com.example.repository.repository.network

import android.content.Context
import com.example.repository.common.Constanta
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to essential header to requests
 */
class EssentialHeaderInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header(Constanta.AUTH_TOKEN, Constanta.API_KEY)
            .header(Constanta.ACCEPT, "application/json")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}