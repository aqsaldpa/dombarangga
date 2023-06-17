package com.project.dombaapps.svc

import com.project.dombaapps.di.response.QRKambingResponse
import com.project.dombaapps.di.model.modelKambing
import com.project.dombaapps.di.model.modelSapi
import com.project.dombaapps.di.response.QRSapiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @POST("cari.php")
//    fun scan(@Body qrCodeRequest: QRRequest): Call<QRResponse>

    @GET("cari.php")
    fun scan(
        @Query("no_kam") NoKambing: String?
    ): Call<QRKambingResponse>?

    @GET("cari_sapi.php")
    fun scanSapi(
        @Query("no_sapi") NoSapi: String?
    ): Call<QRSapiResponse>?

    @GET("get_all_kambing.php")
    fun getAllDataKambing(): Call<List<modelKambing.dataKambing>>

    @GET("get_all_sapi.php")
    fun getAllDataSapi(): Call<List<modelSapi.dataSapi>>

}