package com.example.aad22.ut01.ex03.data

import android.content.SharedPreferences
import android.util.Log
import com.example.aad22.ut01.ex03.domain.News
import com.google.gson.Gson

class NewsLocalSource (val sharedPref: SharedPreferences) {

    fun setNews(news: News){
        val gson = Gson()
        val jsonNews = gson.toJson(news, News::class.java)

        val edit = sharedPref.edit()
        edit.putString(news.id.toString(), jsonNews)
        edit.apply()
    }

    fun findById(newsId: Int): News{
        val gson = Gson()
        val jsonNews = sharedPref.getString(newsId.toString(), "")
        return gson.fromJson<News>(jsonNews, News::class.java)
    }

    fun setNewsList(newList: MutableList<News>){
        for(n:News in newList){
            setNews(n)
        }
    }

    fun getNewsMap(): Map<*,*>{

        /*val gson = Gson()
        val jsonNewsMap:MutableMap<String, News> = sharedPref.all as MutableMap<String, News>
        return gson.fromJson<MutableMap<String, News>>(jsonNewsMap, News::class.java)*/

        val gson = Gson()
        val jsonNews: String = sharedPref.all.toString()
        val map: Map<*, *> = gson.fromJson(jsonNews, Map::class.java)
        Log.d("@dev", map.toString())
        return map
    }


}