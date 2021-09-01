package com.vsking.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vsking.myapplication.api.PagingSourceData
import com.vsking.myapplication.api.RetrofitInstance
import com.vsking.myapplication.api.RetrofitService
import com.vsking.myapplication.api.apidata.ListData
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
class MainActivityViewmodel:ViewModel() {
    lateinit var retrofitService: RetrofitService
    init {
        retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
    }
    fun getListData():Flow<PagingData<ListData>>{
        return Pager (config = PagingConfig(pageSize = 34,maxSize = 200),
        pagingSourceFactory = {PagingSourceData(retrofitService)}
            ).flow.cachedIn(viewModelScope)
    }
}