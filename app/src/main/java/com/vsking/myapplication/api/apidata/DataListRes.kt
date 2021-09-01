package com.vsking.myapplication.api.apidata

import java.io.Serializable

/**
 * Created by Vivek kumar on 9/1/2021.
 * E-mail:- vivekpcst.kumar@gmail.com
 */
data class DataListRes(val info:Info,val results:List<ListData>)
data class ListData(val name:String?,val species:String?):Serializable
data class Info(val count:Int?,val pages:String?,val next:String?,val prev:String)



