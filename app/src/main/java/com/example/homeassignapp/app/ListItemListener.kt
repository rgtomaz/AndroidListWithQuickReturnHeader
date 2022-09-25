package com.example.homeassignapp.app

import com.example.homeassignapp.retrofit.PhotoItem

interface ListItemListener {
    fun onClickPhoto(item: PhotoItem, position: Int)
}