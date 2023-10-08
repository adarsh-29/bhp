package com.example.bhp.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bhp.network.Repo
import com.example.bhp.ui.model.RequestPredectHomePrice
import com.example.bhp.ui.model.ResponseGetLocations
import com.example.bhp.ui.model.ResponsePredectHomePrice
import com.google.gson.Gson

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel constructor(private val repository: Repo, var context: Context) : ViewModel() {


    val responsePrice = MutableLiveData<ResponsePredectHomePrice>()
    var responseGetLocations = MutableLiveData<ResponseGetLocations>()

    fun predict_home_price(bodyParam : RequestPredectHomePrice): MutableLiveData<ResponsePredectHomePrice>{
       // Utility.showLoader(context)
        val param : String = Gson().toJson(bodyParam)
        Log.d("request:", "request_price_pred: $param")

        val call= repository.predict_home_price(bodyParam)

        call.enqueue( object : Callback<ResponsePredectHomePrice> {
            override fun onResponse(call: Call<ResponsePredectHomePrice>, response: Response<ResponsePredectHomePrice>) {
               // Utility.hideLoader()
                val resp : String = Gson().toJson(response.body())
                Log.d("resp:", "response_price_pred: $resp")

                responsePrice.value=response.body()
            }
            override fun onFailure(call: Call<ResponsePredectHomePrice>, t: Throwable) {
               // Utility.hideLoader()
                Toast.makeText(context,t.message, Toast.LENGTH_SHORT).show()
            }
        })

        return responsePrice
    }

    fun get_location_names() {

        val call= repository.get_location_names()
        // Utility.showLoader(context)
        call.enqueue( object : Callback<ResponseGetLocations> {
            override fun onResponse(call: Call<ResponseGetLocations>, response: Response<ResponseGetLocations>) {
                //Utility.hideLoader()
                val resp : String = Gson().toJson(response.body())
                Log.d("resp:", "location: $resp")

                responseGetLocations.value=response.body()
            }
            override fun onFailure(call: Call<ResponseGetLocations>, t: Throwable) {
                //Utility.hideLoader()
                Toast.makeText(context,t.message, Toast.LENGTH_SHORT).show()
            }
        })

    }



}