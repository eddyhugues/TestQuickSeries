package com.quickseries.testapp.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.quickseries.testapp.App
import com.quickseries.testapp.models.Category
import com.quickseries.testapp.models.Resource
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by eddyhugues on 2017-08-10.
 */
object DbUtils {

    private val categories = "data/categories.json"
    private val restaurants = "data/restaurants.json"
    private val vacation_spots = "data/vacation-spot.json"

    private var gson = Gson()

    private fun loadJSONFromAsset(path: String): String? {
        var json: String? = null
        App.instance.assets?.let {
            try {
                val inputStream = it.open(path)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, charset = Charset.forName("UTF-8"))
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }
        return json
    }

    fun categories(): Array<Category>? {
        val listType = object : TypeToken<Array<Category>>() {}.type
        loadJSONFromAsset(categories)?.let {
            return gson.fromJson(it, listType)
        }
        return null
    }

    fun restaurants(): Array<Resource>? {
        val listType = object : TypeToken<Array<Resource>>() {}.type
        loadJSONFromAsset(restaurants)?.let {
            return gson.fromJson(it, listType)
        }
        return null
    }

    fun vacation_spots(): Array<Resource>? {
        val listType = object : TypeToken<Array<Resource>>() {}.type
        loadJSONFromAsset(vacation_spots)?.let {
            return gson.fromJson(it, listType)
        }
        return null
    }

}