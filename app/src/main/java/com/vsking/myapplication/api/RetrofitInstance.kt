package com.vsking.myapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
class RetrofitInstance {
    companion object{
        val baseUrl="https://reqres.in/api/"
        fun getRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}