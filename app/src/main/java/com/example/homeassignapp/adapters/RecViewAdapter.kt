package com.example.homeassignapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.homeassignapp.R
import com.example.homeassignapp.retrofit.PhotoItem

class RecViewAdapter(private val list: List<PhotoItem>) : RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView by lazy { itemView.findViewById(R.id.rvCardImg) }
        private val textView: TextView by lazy { itemView.findViewById(R.id.rvCardTitle) }

        fun bind(item: PhotoItem) {
            textView.text = item.title
            imageView.load(item.getPhotoURL())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size
}