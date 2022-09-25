package com.example.homeassignapp.retrofit

data class PhotoData(
    val photos: Photos,
    val stat: String
)

data class Photos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<PhotoItem>,
    val total: Int
)