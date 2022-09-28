package com.example.aad22.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.example.aad22.ut01.ex01.domain.Customer

class PreferenceLocalSource (private val activity:Activity): Preference {
    val pref = activity.getPreferences(
        Context.MODE_PRIVATE
    )

    /*
    fun saveCustomer(customer: Customer){
        val editor = pref.edit()
        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)

        editor.apply() //de forma asincrona -- cuando nos de igual cuando termine
        // editor.commit() de forma sincrona

        //kotlin style

        /*
        editor.apply{
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)
            apply()
        }
        */

    }


    fun getCustomer(): Customer{
        val editor = pref.edit()
        return Customer(
            pref.getInt("id", 0),
            pref.getString("name", "no existe")!!,
            pref.getString("surname", "no existe")!!,
            pref.getBoolean("isActive", true)
        )
    }

     */


}