package com.example.hc.api

import com.example.hc.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {

    @GET("/api")
    fun getUsers(@Query("page")  page : Int, @Query("results") results : Int) : Call<Result>
}