package com.example.bhp.network

import android.content.Context
import com.example.bhp.util.Constant
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    companion object{

        /** have to be used in case of bearer token Auth**/

        fun apiClient(context: Context): Retrofit{


            val gson = GsonBuilder().setLenient().create()
            val interceptors = HttpLoggingInterceptor()
            interceptors.level = HttpLoggingInterceptor.Level.BODY
            val clients = OkHttpClient.Builder().addInterceptor(interceptors) .build()


            return Retrofit.Builder()
                .baseUrl(Constant.BASE_SERVER_URL)
                .client(clients)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }


    }

}