package com.example.aad22.ut01.ex02.data

import android.app.Activity
import android.content.Context
import com.example.aad22.R
import com.example.aad22.ut01.ex02.domain.CheckFirstTime

class SharedPreferenceLocalSource (val activity: Activity) {

    val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_ut01Ex02), Context.MODE_PRIVATE
    )

    fun saveStatus(){
        val editor = sharedPref.edit()
        editor.putBoolean("First opened?", false)
        editor.apply()
    }

    fun isFirstOpened():Boolean{
        val editor = sharedPref.edit()
        return (
            sharedPref.getBoolean("First opened?", true)
        )
    }
}