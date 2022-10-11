package com.example.aad22.ut01.ex07.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.aad22.R
import com.example.aad22.ut01.ex07.data.LocalDataSource
import com.example.aad22.ut01.ex07.domain.Counter

class Ut01Ex07Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex07)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val localSource = LocalDataSource(sharedPref)

        if(localSource.getCounter(1) == null){
            localSource.saveCounter(Counter(1,1))
        }else{
            val counter = localSource.getCounter(1)
            if (counter != null) {
                if(counter.contador==5){
                    Log.d("@dev", "La aplicacion se ha abierto 5 veces")
                }else{
                    counter.contador = counter.contador + 1
                    localSource.saveCounter(counter)
                }
            }

        }
    }
}