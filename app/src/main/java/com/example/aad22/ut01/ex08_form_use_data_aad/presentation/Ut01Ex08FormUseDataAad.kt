package com.example.aad22.ut01.ex08_form_use_data_aad.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad22.R
import com.example.aad22.ut01.ex08_form_use_data_aad.data.UserRepository
import com.example.aad22.ut01.ex08_form_use_data_aad.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex08_form_use_data_aad.data.local.UsersLocalSource
import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Userex08

class Ut01Ex08FormUseDataAad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex06)

        init()
    }

    fun init(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)

        val usersRepository = UserRepository(
            UsersLocalSource(sharedPref),
            UsersRemoteSource()
        )

            var users = usersRepository.getUsers()
            Log.d("@dev", "----------------------------------------------------------------------------")
            Log.d("@dev", "IMPRIMIMOS LA LISTA ENTERA")
            showUsers(users)
            Log.d("@dev", "----------------------------------------------------------------------------")
            Log.d("@dev", "OBTENEMOS EL USER CON ID 1")
            val singleUser = usersRepository.findUserById(1)
            Log.d("@dev", singleUser.toString())
            Log.d("@dev", "----------------------------------------------------------------------------")
            Log.d("@dev", "ELIMINAMOS EL USUARIO CON ID 3")
            usersRepository.removeUser(3)
            users = usersRepository.localSource.getUsers()
            Log.d("@dev", "MOSTRAMOS LA LISTA DE NUEVO")
            showUsers(users)
            Log.d("@dev", "----------------------------------------------------------------------------")

    }

    fun showUsers(lista: List<Userex08>?){
        lista?.forEach {
            Log.d("@dev", it.toString())
        }
    }
}