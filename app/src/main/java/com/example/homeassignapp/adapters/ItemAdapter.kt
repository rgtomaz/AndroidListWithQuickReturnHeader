package com.example.homeassignapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.example.homeassignapp.R
import com.example.homeassignapp.appgenerals.ListItemListener
import com.example.homeassignapp.retrofit.PhotoItem

class ItemAdapter(context: Context, private val list: List<PhotoItem>, private val listener: ListItemListener) :
    ArrayAdapter<PhotoItem>(context, R.layout.list_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View? = convertView

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        view?.let {
            val item = list[position]

            val image: ImageView = view.findViewById(R.id.cardImg)
            image.load(item.getPhotoURL())
            image.setOnClickListener { listener.onClickPhoto(item, position) }

            val title: TextView = view.findViewById(R.id.cardTitle)
            title.text = item.title
        }

        return view!!
    }
}