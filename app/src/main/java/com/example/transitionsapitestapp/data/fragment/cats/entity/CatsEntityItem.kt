package com.example.transitionsapitestapp.data.fragment.cats.entity

data class CatsEntityItem(
    val breed_ids: Any,
    val breeds: List<Any>,
    val categories: List<Category>,
    val created_at: String,
    val height: Int,
    val id: String,
    val original_filename: String,
    val sub_id: Any,
    val url: String,
    val width: Int
)