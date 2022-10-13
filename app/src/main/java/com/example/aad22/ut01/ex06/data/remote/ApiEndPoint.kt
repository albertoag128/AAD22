package com.example.aad22.ut01.ex06.data.remote

import com.example.aad22.ut01.ex06.domain.User
import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Userex08
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUser(@Path("id")id:Int): Call<User>

}