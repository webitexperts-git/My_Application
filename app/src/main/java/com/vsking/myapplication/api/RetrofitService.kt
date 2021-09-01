package com.vsking.myapplication.api

import com.vsking.myapplication.api.apidata.DataListRes
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
interface RetrofitService {
    @GET("character?")
    suspend fun getDatalist(@Query("page")page: Int): DataListRes
}