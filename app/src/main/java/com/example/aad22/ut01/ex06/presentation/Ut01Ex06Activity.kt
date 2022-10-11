package com.example.aad22.ut01.ex06.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad22.ut01.ex06.data.UserRepository
import com.example.aad22.ut01.ex06.data.local.UsersLocalSource
import com.example.aad22.ut01.ex06.data.remote.RetrofitClient
import com.example.aad22.ut01.ex06.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex06.domain.User

class Ut01Ex06Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    fun init(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        val usersRepository = UserRepository(
            RetrofitClient(),
            UsersLocalSource(sharedPref)
        )

        Thread{
            var users = usersRepository.getUsers()
            Log.d("@dev", "----------------------------------------------------------------------------")
            showUsers(users)
            Log.d("@dev", "----------------------------------------------------------------------------")
            val singleUser = usersRepository.findUserById(1)
            Log.d("@dev", singleUser.toString())
            Log.d("@dev", "----------------------------------------------------------------------------")
            usersRepository.removeUser(3)
            users = usersRepository.localSource.getUsers()
            showUsers(users)
        }.start()
    }

    fun showUsers(lista: List<User>?){
        if (lista != null) {
            lista.forEach {
                Log.d("@dev", it.toString())
            }
        }
    }
}