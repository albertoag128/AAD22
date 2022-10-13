package com.example.aad22.ut01.ex06.domain

import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Address
import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Company
import com.example.aad22.ut01.ex08_form_use_data_aad.domain.Geo

data class User(val id:Int, val name:String, val username:String, val email:String,
                val address: Address, val phone:String, val website:String, val company: Company
)

data class Geo (val lat:String, val lng:String)

data class Company (val name:String, val catchPhrase:String, val bs:String)

data class Address (val street:String, val suite:String, val city:String, val zipcode:String, val geo: Geo)