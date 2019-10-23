package com.example.hc.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hc.api.ApiCalls
import com.example.hc.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    private val apiCalls = RetrofitClient.getRetrofit().create(ApiCalls::class.java)
    val allUsers = MutableLiveData<List<User>>()

    fun getUsers(): MutableLiveData<List<User>>? {
        apiCalls.getUsers(1, 20).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.isSuccessful) allUsers.postValue(response.body()?.results)
            }
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("Fetching users error", " " + t.message)
            }
        })
        return allUsers
    }
}