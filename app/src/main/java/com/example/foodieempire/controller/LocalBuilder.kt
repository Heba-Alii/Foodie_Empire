package com.example.foodieempire.controller

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.foodieempire.model.data.MealsDao
import com.example.foodieempire.model.pojo.Meal

@Database(entities = arrayOf(Meal::class), version = 2)
abstract class LocalBuilder : RoomDatabase() {
    abstract fun mealsDao(): MealsDao?

    companion object {
        private var dbInstance: LocalBuilder? = null
        @JvmStatic
        fun getInstance(context: Context): LocalBuilder? {
            if (dbInstance == null) {
                dbInstance = databaseBuilder(
                    context.applicationContext,
                    LocalBuilder::class.java, "MealsDB"
                ).build()
            }
            return dbInstance
        }
    }
}