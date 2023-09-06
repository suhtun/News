package com.sumyat.newsapp.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.sumyat.newsapp.commom.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private fun createMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(createMoshi()))
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level= HttpLoggingInterceptor.Level.BODY }).build())
        .build()

    val newsApi = getRetrofit().create(NewsApi::class.java)
}