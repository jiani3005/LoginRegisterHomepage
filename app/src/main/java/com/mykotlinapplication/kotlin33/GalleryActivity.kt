package com.mykotlinapplication.kotlin33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_gallery)

//        val bundle = intent.getBundleExtra("bundle")
//        val hotel = bundle.getParcelable<Hotel>("hotel")

        gallery_name.text = intent.getStringExtra("name")
        gallery_description.text = intent.getStringExtra("description")
        gallery_price.text = intent.getStringExtra("price")
        gallery_rating.text = intent.getStringExtra("rating")
        Glide.with(this).load(intent.getStringExtra("image")).into(gallery_image)

    }
}
