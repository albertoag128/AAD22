package com.example.aad22.ut01.ex08_form_use_data_aad.data

import com.example.aad22.ut01.ex08_form_use_data_aad.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Userex08

class UserRepository(val localSource: com.example.aad22.ut01.ex08_form_use_data_aad.data.local.UsersLocalSource, val remoteSource: UsersRemoteSource){

    fun getUsers():List<Userex08>?{
        return localSource.getUsers().isEmpty().run{
            val users = remoteSource.getUsers()
            localSource.saveUsers(users)
            users
        }
    }

    fun findUserById(userId:Int): Userex08?{
        return localSource.findUserById(userId)?.let {
            remoteSource.findById(userId)
        }
    }

    fun removeUser(userId:Int){
        localSource.removeUser(userId)
    }

}