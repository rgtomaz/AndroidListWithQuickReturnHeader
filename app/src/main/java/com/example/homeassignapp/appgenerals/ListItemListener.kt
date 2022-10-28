package com.example.homeassignapp.appgenerals

import com.example.homeassignapp.retrofit.PhotoItem

interface ListItemListener {
    fun onClickPhoto(item: PhotoItem, position: Int)
}