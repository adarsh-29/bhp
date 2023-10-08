package com.example.bhp.network

import android.content.Context
import com.example.bhp.ui.model.RequestPredectHomePrice
import com.example.bhp.ui.model.ResponseGetLocations
import com.example.bhp.ui.model.ResponsePredectHomePrice
import retrofit2.Call

class Repo constructor(private val context: Context) {

    val apiService : ApiService = ApiClient.apiClient(context).create(ApiService::class.java)


    fun get_location_names(): Call<ResponseGetLocations> = apiService.get_location_names()
    fun predict_home_price(bodyParam : RequestPredectHomePrice): Call<ResponsePredectHomePrice> = apiService.predict_home_price(bodyParam)

}