package com.example.aad22.ut01.ex01.presentacion

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aad22.R
import com.example.aad22.ut01.ex01.data.PreferenceLocalSource
import com.example.aad22.ut01.ex01.data.SharedPreferenceLocalSource
import com.example.aad22.ut01.ex01.domain.Customer
import java.util.Objects
import javax.xml.transform.Source

class Ut01Ex01 : AppCompatActivity(){

    private fun initPreference(source: kotlin.Any){

        if(source is PreferenceLocalSource){
            val spCustomer = SharedPreferenceLocalSource(this)

            source.saveCustomer(Customer(1, "Customer1", "Surname1", true), spCustomer.sharedPref)
            val newCustomer = source.getCustomer(spCustomer.sharedPref)
            Log.d("@dev", "Customer:  $newCustomer")
        }

        if(source is SharedPreferenceLocalSource){
            val spCustomer = SharedPreferenceLocalSource(this)

            source.saveCustomer(Customer(2, "Customer2", "Surname2", true), spCustomer.sharedPref)
            val newCustomer = source.getCustomer(spCustomer.sharedPref)
            Log.d("@dev", "Customer:  $newCustomer")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        val spCustomer = PreferenceLocalSource(this)
        val spSharedCustomer = SharedPreferenceLocalSource(this)

        initPreference(spCustomer)
        initPreference(spSharedCustomer)

    }
}