package com.example.hseapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.hseapp.*
import com.example.hseapp.databinding.ActivityHomeBinding
import com.example.hseapp.ui.fragments.CalenderFragment
import com.example.hseapp.ui.fragments.CourseFragment
import com.example.hseapp.ui.fragments.GradesFragment
import com.example.hseapp.ui.fragments.ProfileFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        val calenderFragment = CalenderFragment.newInstance()
        setCurrentFragment(calenderFragment)
        val courseFragment = CourseFragment.newInstance()
        val gradeFragment = GradesFragment.newInstance()
        val userFragment = ProfileFragment.newInstance()

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