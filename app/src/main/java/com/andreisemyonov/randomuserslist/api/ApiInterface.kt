package com.andreisemyonov.randomuserslist.api

import com.andreisemyonov.randomuserslist.model.Example
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/?results=20")
    fun getUsersList(): Call<Example?>?
}