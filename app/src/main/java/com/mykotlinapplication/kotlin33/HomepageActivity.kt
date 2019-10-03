package com.mykotlinapplication.kotlin33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_homepage.*

class HomepageActivity : AppCompatActivity() {

    val names = arrayListOf<String>()
    var images = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_homepage)

        addItems()

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = RecyclerViewAdapter(names, images, this)

    }

    fun addItems () {
        names.add("Mickey")
        images.add("https://i.pinimg.com/originals/10/2d/93/102d93da2543d8ffaa5d5e40d3d29479.jpg")

        names.add("Pooh")
        images.add("https://i.pinimg.com/originals/11/fa/35/11fa358b86bc036d273b6d9571c002ff.jpg")

        names.add("Donald Duck")
        images.add("https://img-new.cgtrader.com/items/1939527/7e562bd2d7/baby-donald-duck-cute-3d-model-obj-mtl-fbx-stl-wrl-wrz.jpg")

        names.add("Goofy")
        images.add("https://i.pinimg.com/originals/fd/6f/43/fd6f436c70d4f2da7e81551afb92f458.jpg")

        names.add("Chipmunk")
        images.add("https://media1.tenor.com/images/ecdab77cfafea8f98f50cd267e57f8c5/tenor.gif?itemid=9499708")

        names.add("Minnie")
        images.add("https://i.pinimg.com/originals/f8/f8/2e/f8f82ef2891865720577dab196297417.jpg")

        names.add("Tigger")
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQOUfFLMz5IZx1Lod2pWvwNOtqqjScOhceZa8SyBkTdkhuZ1_F")

        names.add("Eeyore")
        images.add("https://i.pinimg.com/originals/46/43/d5/4643d5f044bbe31783d6e6878a5ceb87.jpg")

        names.add("Piglet")
        images.add("https://i.pinimg.com/originals/85/08/01/8508018e58de384772782e33fb93b8c1.png")

    }
}
