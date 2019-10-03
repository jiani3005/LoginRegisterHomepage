package com.mykotlinapplication.kotlin33

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

var hotel: Hotel? = null

class RecyclerViewAdapter(val items: ArrayList<Hotel>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].name
        Glide.with(context).load(items[position].image).into(holder.image)
        holder.description.text = items[position].description
        holder.rating.text = items[position].rating
        holder.price.text = items[position].price

        hotel = items[position]
        holder.item_row.setOnClickListener {
            var intent = Intent(context, GalleryActivity::class.java)

//            var bundle = Bundle()
//            bundle.putParcelable("hotel", hotel)
            intent.putExtra("name", items[position].name)
            intent.putExtra("description", items[position].description)
            intent.putExtra("price", items[position].price)
            intent.putExtra("rating", items[position].rating)
            intent.putExtra("image", items[position].image)
            context.startActivity(intent)

        }


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
    val item_row = view.list_item_row
//
//    val context = view.context
//    override fun onClick(v: View?) {
//        var homepageHelper = context as HomepageHelper
//        var bundle = Bundle()
//        Log.i("datapass", "adapter: ${hotel?.name}")
//        bundle.putParcelable("hotel", hotel)
//        homepageHelper.goToGallery(v, adapterPosition)
//    }
}