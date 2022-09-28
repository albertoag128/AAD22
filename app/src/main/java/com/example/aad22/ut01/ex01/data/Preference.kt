package com.example.aad22.ut01.ex01.data

import android.content.SharedPreferences
import com.example.aad22.ut01.ex01.domain.Customer

interface Preference {
    fun saveCustomer(customer: Customer, sharedPref: SharedPreferences){
        val editor = sharedPref.edit()
        editor.apply {
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)
            apply()
        }
    }

    fun getCustomer(sharedPref: SharedPreferences): Customer {
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!, // La doble exclamación evita que de error, al indicar al programa que aceptamos la posibilidad de que el resultado sea null
            sharedPref.getString("surname", "no existe") ?: "no existe", // Operador ternario
            sharedPref.getBoolean("is_active", true)
        )
    }
}