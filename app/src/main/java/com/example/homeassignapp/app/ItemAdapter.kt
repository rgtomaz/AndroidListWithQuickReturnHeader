package com.example.homeassignapp.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.homeassignapp.R
import com.example.homeassignapp.retrofit.Photo

class ItemAdapter(context: Context, private val list: List<Photo>) :
    ArrayAdapter<Photo>(context, R.layout.list_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        view?.let {
            val photoItem = list[position]

            val image: ImageView = view.findViewById(R.id.cardImg)
            image.load(photoItem.getPhotoURL())

            val title: TextView = view.findViewById(R.id.cardTitle)
            title.text = photoItem.title
        }

        return view!!
    }
}