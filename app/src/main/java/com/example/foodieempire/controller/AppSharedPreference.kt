package com.example.foodieempire.controller

import android.content.Context
import android.content.SharedPreferences

object AppSharedPreference {
    private fun getSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences("userData", Context.MODE_PRIVATE)
    }

    fun writeToSharedPrefernce(context: Context, name: String?, phone: String?, mail: String?) {
        getSharedPreference(context).edit().putString("name", name).apply()
        getSharedPreference(context).edit().putString("phone", phone).apply()
        getSharedPreference(context).edit().putString("mail", mail).apply()
    }

    fun writeToSharedPrefernce(context: Context, name: String?) {
        getSharedPreference(context).edit().putString("name", name).apply()
    }

    @JvmStatic
    fun getName(context: Context): String? {
        return getSharedPreference(context).getString("name", "")
    }
}