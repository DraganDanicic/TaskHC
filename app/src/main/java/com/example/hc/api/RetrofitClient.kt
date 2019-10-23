package com.example.hc.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://randomuser.me"

class RetrofitClient {

    companion object {
        fun getRetrofit(): Retrofit {
            val retrofit: Retrofit

            val interceptor = Interceptor {
                val initialRequest = it.request()
                val httpUrl = initialRequest.url()
                val url = httpUrl.newBuilder().build()
                val requestBuilder = initialRequest.newBuilder().url(url)
                val request = requestBuilder.build()
                it.proceed(request)

            }

            val httpBuilder = OkHttpClient.Builder()
            val httpClient: OkHttpClient = httpBuilder.addInterceptor(interceptor).build()

            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()

            return retrofit
        }
    }


}