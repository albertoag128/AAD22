package com.example.aad22.ut01.ex05.data.local

import android.content.SharedPreferences
import com.example.aad22.ut01.ex03.domain.News
import com.example.aad22.ut01.ex05.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex05.domain.User
import com.google.gson.Gson

class UsersLocalSource (val sharedPref:SharedPreferences) {

    private val gson = Gson()

    fun saveUser(user:User){
        val jsonUser = gson.toJson(user, User::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }

    fun saveUsers(usersList: List<User>){
        for(u:User in usersList){
            saveUser(u)
        }
    }

    fun getUsers(): List<User>{
        val usersList = mutableListOf<User>()
        sharedPref.all.forEach{
            var user = gson.fromJson(it.value as String, User::class.java)
            usersList.add(user)
        }
        return usersList
    }

    fun findById(userId:Int):User{
        val jsonUser = sharedPref.getString(userId.toString(),null)
        return gson.fromJson<User>(jsonUser, User::class.java)
    }

    fun remove(userId:Int){
        sharedPref.edit().remove(userId.toString()).apply()
    }

}