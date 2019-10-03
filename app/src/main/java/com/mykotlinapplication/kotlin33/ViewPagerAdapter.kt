package com.mykotlinapplication.kotlin33

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FragmentRegister()
            else -> FragmentLogin()
        }
    }

    override fun getCount(): Int {
        return 2
    }

}