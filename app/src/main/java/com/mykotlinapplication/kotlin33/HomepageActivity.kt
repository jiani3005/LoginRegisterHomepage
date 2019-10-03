package com.mykotlinapplication.kotlin33

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_homepage.*

class HomepageActivity : AppCompatActivity() {

    var hotels = arrayListOf<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_homepage)

        addItems()

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = RecyclerViewAdapter(hotels, this)

    }

    fun addItems () {
        // Hotel(name, description, rating, price, image)
        hotels.add(Hotel("Berjaya Langkawi Resort", "Langkawi", "4.0/5", "$88/night",
            "https://www.berjayahotel.com/sites/default/files/special-offer-right_blr1.jpg"))

        hotels.add(Hotel("Shangri-La Hotel", "Kuala Lumpur", "4.5/5", "$103/night",
            "https://images.trvl-media.com/hotels/1000000/30000/20700/20634/c3d8dffb_z.jpg"))

        hotels.add(Hotel("Traders Hotel", "Kuala Lumpur", "4.3/5", "$99/night",
            "https://dak95nwic4sny.cloudfront.net/73/traders-hotel-kuala-lumpur-39859861-1530200286-WideInspirationalPhoto1170.jpg"))

        hotels.add(Hotel("Mandarin Oriental", "Kuala Lumpur", "4.3/5", "$129/night",
            "https://luxurylaunches.com/wp-content/uploads/2017/05/Mandarin-Oriental-spa-review-1170x780.jpg"))

        hotels.add(Hotel("Grand Hyatt", "Kuala Lumpur", "4.4/5", "$137/night",
            "https://pix10.agoda.net/hotelImages/337419/-1/50c3c00607896aa6b3226d07f5d4fb13.jpg?s=1024x768"))

        hotels.add(Hotel("Meritus Pelangi Beach Resort & Spa", "Langkawi", "4.0/5", "$125/night",
            "https://d2felfhvpayf79.cloudfront.net/media/images/properties/malaysia/langkawi/meritus-pelangi-beach-resort-spa-langkawi/pbl_aerial_04_501_1200x800.jpg"))

        hotels.add(Hotel("The Westin Resort & Spa", "Langkawi", "4.5/5", "$155/night",
            "https://images.trvl-media.com/hotels/1000000/40000/34700/34686/1900651e_z.jpg"))

        hotels.add(Hotel("PARKROYAL", "Penang", "4.0/5", "$94/night",
            "https://q-cf.bstatic.com/images/hotel/max1024x768/136/136176698.jpg"))

        hotels.add(Hotel("The Danna", "Langkawi", "5.0/5", "$370/night",
            "https://www.telegraph.co.uk/content/dam/Travel/hotels/asia/malaysia/The-Danna-Langkawi-p.jpg"))

    }
}
