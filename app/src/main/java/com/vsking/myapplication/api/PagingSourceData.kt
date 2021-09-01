package com.vsking.myapplication.api

import android.net.Uri
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vsking.myapplication.api.apidata.ListData

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
class PagingSourceData(val apiservice: RetrofitService): PagingSource<Int, ListData>() {
    override fun getRefreshKey(state: PagingState<Int, ListData>): Int? {
        return state.anchorPosition
    }

    fun getLastNCharsOfString(str: String?, n: Int): String? {
        var lastnChars = if (str.isNullOrEmpty()){
            ""
        }else{
            str
        }
        if (lastnChars.length > n) {
            lastnChars = lastnChars.substring(lastnChars.length - n, lastnChars.length)
        }
        return lastnChars
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListData> {
        return try {
            val result = apiservice.getDatalist(params.key ?: firstPage)

            LoadResult.Page(
                data = result.results,
                prevKey = null,
                nextKey = (getLastNCharsOfString(result.info.next,1))?.toInt() ?: firstPage.plus(1)
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    companion object{
        private const val firstPage = 1
    }
}