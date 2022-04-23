package com.example.hseapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hseapp.*
import com.example.hseapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        val calenderFragment = Fragment1.newInstance()
        setCurrentFragment(calenderFragment)
        val courseFragment = Fragment2.newInstance()
        val gradeFragment = Fragment3.newInstance()
        val userFragment = Fragment4.newInstance()

        binding.menubar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.calender -> setCurrentFragment(calenderFragment)
                R.id.course -> setCurrentFragment(courseFragment)
                R.id.grade -> setCurrentFragment(gradeFragment)
                R.id.profile -> setCurrentFragment(userFragment)
            }
            true
        }
    }

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.homecontainer, fragment, "Menu Item").addToBackStack("Menu Item").commit()
    }
}