package com.example.aad22.ut01.ex01.data

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.aad22.R
import com.example.aad22.ut01.ex01.domain.Customer

class SharedPreferenceLocalSource (val activity: Activity):Preference {
    val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_ut01Ex01), Context.MODE_PRIVATE
    )


    /*
    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
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


    fun getCustomer(): Customer {
        val editor = sharedPref.edit()
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!,
            sharedPref.getString("surname", "no existe")!!,
            sharedPref.getBoolean("isActive", true)
        )
    }
    */


}