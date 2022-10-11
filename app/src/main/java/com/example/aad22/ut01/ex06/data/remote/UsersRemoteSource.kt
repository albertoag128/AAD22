package com.example.aad22.ut01.ex06.data.remote

import com.example.aad22.ut01.ex06.domain.Address
import com.example.aad22.ut01.ex06.domain.Company
import com.example.aad22.ut01.ex06.domain.Geo
import com.example.aad22.ut01.ex06.domain.User

class UsersRemoteSource {

    fun getUsers():List<User>{
        val company1 = Company("AlbertoSA", "Multi-layered client-server neural-net", "harness real-time e-markets")
        val geo1 = Geo("-37.3159", "81.1496")
        val address1 = Address("Calle tormenta", "Suite45", "Avila", "05002", geo1)

        return mutableListOf(
            User(1, "Alberto", "Albertoag", "alberto@cosas", address1, "920123123", "alberto.com", company1)
        )
    }

    /*fun findById(userId:Int):User{
        return User(userId, "User$userId", "Username$userId", "Email$userId", )
    }*/

}