package com.example.foodieempire.model.pojo

import java.io.Serializable

data class Category(
    var idCategory: String,
    var strCategory: String,
    var strCategoryThumb: String,
    var strCategoryDescription: String
) : Serializable