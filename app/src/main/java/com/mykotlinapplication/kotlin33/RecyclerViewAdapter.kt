package com.mykotlinapplication.kotlin33

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(val items: ArrayList<Hotel>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name
        Glide.with(context).load(items[position].image).into(holder.image)
        holder.description.text = items[position].description
        holder.rating.text = items[position].rating
        holder.price.text = items[position].price
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name = view.item_name
    val image = view.item_image
    val description = view.item_description
    val rating = view.item_rating
    val price = view.item_price
}