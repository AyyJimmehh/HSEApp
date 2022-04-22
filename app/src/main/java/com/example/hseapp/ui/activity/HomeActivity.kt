package com.example.hseapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hseapp.*
import com.example.hseapp.databinding.ActivityHomeBinding
import com.example.hseapp.databinding.ActivityLoginBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        val firstFragment = Fragment1.newInstance()
        setCurrentFragment(firstFragment)
        val secondFragment = Fragment2.newInstance()
        val thirdFragment = Fragment3.newInstance()
        val fourthFragment = Fragment4.newInstance()

        binding.menubar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.calender -> setCurrentFragment(firstFragment)
                R.id.course -> setCurrentFragment(secondFragment)
                R.id.grade -> setCurrentFragment(thirdFragment)
                R.id.profile -> setCurrentFragment(fourthFragment)
            }
            true
        }

    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.homecontainer, fragment, "Menu Item").addToBackStack("Menu Item").commit()
    }
}