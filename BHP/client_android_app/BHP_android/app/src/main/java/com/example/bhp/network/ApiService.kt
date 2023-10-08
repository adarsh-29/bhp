package com.example.bhp.network

import com.example.bhp.ui.model.RequestPredectHomePrice
import com.example.bhp.ui.model.ResponseGetLocations
import com.example.bhp.ui.model.ResponsePredectHomePrice
import com.example.bhp.util.Constant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    // Register and login
    @GET(Constant.get_location_names)
    fun get_location_names(): Call<ResponseGetLocations>

    @POST(Constant.predict_home_price)
    fun predict_home_price(@Body bodyParam : RequestPredectHomePrice): Call<ResponsePredectHomePrice>
}