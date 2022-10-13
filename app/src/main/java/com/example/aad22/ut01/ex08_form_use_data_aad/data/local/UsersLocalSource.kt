package com.example.aad22.ut01.ex08_form_use_data_aad.data.local

import android.content.SharedPreferences
import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Userex08
import com.google.gson.Gson

class UsersLocalSource (val sharedPref:SharedPreferences) {

    private val gson = Gson()

    fun saveUser(user: Userex08){

        val jsonUser = gson.toJson(user, Userex08::class.java)

        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }

    fun saveUsers(lista:List<Userex08>?){
        lista?.forEach {
            saveUser(it)
        }
    }

    fun getUsers():List<Userex08>{
        val listUsers = mutableListOf<Userex08>()
        sharedPref.all.forEach { entry ->
            var user = gson.fromJson<Userex08>(entry.value as String, Userex08::class.java)
            listUsers.add(user)
        }
        return listUsers
    }

    fun findUserById(userId:Int): Userex08?{
        val jsonUser = sharedPref.getString(userId.toString(), null)
        return gson.fromJson(jsonUser, Userex08::class.java)
    }

    fun updateUser(user:Userex08){
        saveUser(user)
    }

    fun removeUser(userId:Int){
        sharedPref.edit().remove(userId.toString()).apply()
    }

}