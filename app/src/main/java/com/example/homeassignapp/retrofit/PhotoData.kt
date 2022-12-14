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