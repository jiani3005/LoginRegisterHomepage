package com.mykotlinapplication.kotlin33

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class FragmentLogin: Fragment() {

    var dataPasser: DataPassHelper? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as DataPassHelper
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        var sharedPreferences = activity!!.getSharedPreferences("kotlin33preferences", Context.MODE_PRIVATE)
        view.login_username.setText(sharedPreferences.getString("username", ""))
        view.login_password.setText(sharedPreferences.getString("password", ""))
        view.checkBox_remember.isChecked = sharedPreferences.getBoolean("remember", false)

        view.button_login.setOnClickListener {
            var bundle = Bundle()

            bundle.putString("username", view.login_username.text.toString())
            bundle.putString("password", view.login_password.text.toString())

            var editor = sharedPreferences.edit()
            if (view.checkBox_remember.isChecked) {
                editor.putString("username", view.login_username.text.toString())
                editor.putString("password", view.login_password.text.toString())
                editor.putBoolean("remember", true)
                editor.commit()
            } else {
                editor.clear().commit()
                view.login_username.setText("")
                view.login_password.setText("")
                view.checkBox_remember.isChecked = false
            }

            dataPasser!!.login(bundle)
        }


        return view
    }
}