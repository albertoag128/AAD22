package com.example.aad22.ut01.ex05.data

import com.example.aad22.ut01.ex05.data.local.UsersLocalSource
import com.example.aad22.ut01.ex05.data.remote.UsersRemoteSource
import com.example.aad22.ut01.ex05.domain.User

class UserRepository(

    val localSource:UsersLocalSource,
    val remoteSource:UsersRemoteSource

) {

    //First from local and after that, from remote

    fun getUsers(): List<User>{
        var users = localSource.getUsers()
        if(users==null || users.isEmpty()){
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }
        return users
    }

    fun findById(userId:Int): User{
        var user = localSource.findById(userId)
        if(user==null){
            user = remoteSource.findById(userId)
        }
        return user
    }

    fun remove(userId: Int){
        localSource.remove(userId)
    }

}