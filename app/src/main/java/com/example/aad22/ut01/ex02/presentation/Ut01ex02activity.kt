package com.example.aad22.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.CheckResult
import com.example.aad22.R
import com.example.aad22.ut01.ex02.data.SharedPreferenceLocalSource
import com.example.aad22.ut01.ex02.domain.CheckFirstTime


class Ut01ex02activity : AppCompatActivity() {

    private fun initPreference(){
        val appCheck = SharedPreferenceLocalSource(this)

        if(appCheck.isFirstOpened()){
            appCheck.saveStatus()
            Log.d("@dev", "Es la primera vez que se abre")
        }else{
            Log.d("@dev", "NO es la primera vez que se abre")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02activity)

        initPreference()

    }
}