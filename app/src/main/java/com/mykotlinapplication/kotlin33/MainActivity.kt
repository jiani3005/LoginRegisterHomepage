package com.mykotlinapplication.kotlin33

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DataPassHelper{

    var users = arrayListOf<User>()

    override fun register(bundle: Bundle) {
        var user = User(bundle.getString("username"), bundle.getString("email"), bundle.getString("password"))
        users.add(user)
//        Log.i("datapass", "register: " + user.toString())
    }

    override fun login(bundle: Bundle) {
        var username = bundle.getString("username")
        var password = bundle.getString("password")
//        Log.i("datapass", "login: username=$username, password=$password")

        var match = false

        for (e in users) {
//            Log.i("datapass", "login compare: " + e.toString())
//            Log.i("datapass", "username same? ${e.username.equals(username)}")
//            Log.i("datapass", "password same? ${e.password.equals(password)}")

            if ((e.username.equals(username)) && (e.password.equals(password))) {
                match = true
                val intent = Intent(this, HomepageActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()

//                supportFragmentManager.beginTransaction().add(R.id.mainact, FragmentHomepage()).commit()
            }
        }

        if (!match) {
            Toast.makeText(this, "You have entered wrong username/password.\nTry again.", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sharedPreferences = getSharedPreferences("kotlin33preferences", Context.MODE_PRIVATE)


        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))
        tablayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab) { }

            override fun onTabUnselected(p0: TabLayout.Tab) { }

            override fun onTabSelected(p0: TabLayout.Tab) {
                viewPager.currentItem = p0.position
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId

        when (id) {
            R.id.menuItem_clearPreferences -> {
                var sp = getSharedPreferences("kotlin33preferences", Context.MODE_PRIVATE)
                var editor = sp.edit()
                editor.clear().commit()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}
