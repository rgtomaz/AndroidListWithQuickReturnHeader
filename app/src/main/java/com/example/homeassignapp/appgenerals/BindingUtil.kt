package com.example.homeassignapp.appgenerals

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.homeassignapp.retrofit.PhotoItem

@BindingAdapter("loadImage")
fun ImageView.setLoadImage(item: PhotoItem) {
    load(item.getPhotoURL())
}

@BindingAdapter("showProperties")
fun TextView.setShowProperties(item: PhotoItem) = item.let { photo ->
    val content = "Title: ".plus(photo.title).plus("\n")
        .plus("Farm: ").plus(photo.farm).plus("\n")
        .plus("Id: ").plus(photo.id).plus("\n")
        .plus("Is Family: ").plus(photo.isfamily).plus("\n")
        .plus("Is Friend: ").plus(photo.isfriend).plus("\n")
        .plus("Is Public: ").plus(photo.ispublic).plus("\n")
        .plus("Owner: ").plus(photo.owner).plus("\n")
        .plus("Secret: ").plus(photo.secret).plus("\n")
        .plus("Server: ").plus(photo.server)

    text = content
}
