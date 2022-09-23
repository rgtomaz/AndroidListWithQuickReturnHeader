package com.example.homeassignapp.retrofit

import retrofit2.Response
import retrofit2.http.GET

private const val CUSTOM_URL =
    "/rakuten-rewards/photos.json?method=flickr.photos.getRecent&api_key=fee10de350d1f31d5fec0eaf330d2dba&page=1&format=json&nojsoncallback=true&safe_search=true"

interface PhotoDetailsApi {

    @GET(CUSTOM_URL)
    suspend fun getPhotoDetails(): Response<PhotoPack>

}