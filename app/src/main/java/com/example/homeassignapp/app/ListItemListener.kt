package com.example.homeassignapp.app

import com.example.homeassignapp.retrofit.Photo

interface ListItemListener {
    fun onClickPhoto(item: Photo, position: Int)
}