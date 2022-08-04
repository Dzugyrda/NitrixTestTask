package com.example.nitrixtesttask.repository.db

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {

//    @TypeConverter
//    fun fromList(list: List<String>): String {
//        return list.get(0)
//    }
//
//    @TypeConverter
//    fun toList(str: String): List<String> {
//        return listOf(str)
//    }

    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType: Type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}