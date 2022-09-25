package com.example.homeassignapp.retrofit

data class PhotoItem(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
) {
    fun getPhotoURL(): String {
        val baseURL = "https://live.staticflickr.com/"

        return baseURL
            .plus(this.server).plus("/")
            .plus(this.id).plus("_")
            .plus(this.secret).plus("_b.jpg")
    }
}