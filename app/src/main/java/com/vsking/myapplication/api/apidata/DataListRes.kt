package com.vsking.myapplication.api.apidata

import java.io.Serializable

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
data class DataListRes(val page: String?,val per_page:String?,val total:String,
                       val total_pages:String?,val data:List<ListData>)
data class ListData(val first_name:String?,val email:String?):Serializable

