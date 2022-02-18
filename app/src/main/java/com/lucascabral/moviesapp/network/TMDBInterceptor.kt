package com.lucascabral.moviesapp.network

import com.lucascabral.moviesapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TMDBInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newURL = chain.request().url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.tokenTMDB).build()

        val newRequest = chain.request().newBuilder().url(newURL).build()

        return chain.proceed(newRequest)
    }
}