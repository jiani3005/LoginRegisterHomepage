package com.mykotlinapplication.kotlin33

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(val names: ArrayList<String>, val images:ArrayList<String>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = names.get(position)
        Glide.with(context).load(images.get(position)).into(holder.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return names.size
    }


}

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val name = view.item_name
    val image = view.item_image
}