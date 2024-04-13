package com.example.foodieempire.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "meals_table")
class Meal(
    @field:PrimaryKey var idMeal: String,
    var strMeal: String,
    var strMealThumb: String,
    var userId: String
) : Serializable