package com.lucascabral.moviesapp.network

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.File
import java.util.concurrent.TimeUnit

class ServiceProvider(
    context: Context
) {

    private val baseUrl = "https://api.themoviedb.org/3/"
    private val contentType = "application/json".toMediaType()
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .callTimeout(15, TimeUnit.SECONDS)
        .cache(
            Cache(
                directory = File(context.cacheDir, "http_cache"),
                maxSize = 1024L * 1024L
            )
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    fun <API> createService(apiClass: Class<API>) : API = retrofit.create(apiClass)
}