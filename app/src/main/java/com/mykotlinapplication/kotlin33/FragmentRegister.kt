package com.mykotlinapplication.kotlin33

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_register.view.*

class FragmentRegister: Fragment(){

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
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        view.button_submitRegister.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("username", view.register_username.text.toString())
            bundle.putString("email", view.register_email.text.toString())
            bundle.putString("password", view.register_password.text.toString())

            dataPasser!!.register(bundle)

            view.register_username.setText("")
            view.register_email.setText("")
            view.register_password.setText("")
            Toast.makeText(activity, "Register success! ", Toast.LENGTH_SHORT).show()
        }


        return view
    }
}