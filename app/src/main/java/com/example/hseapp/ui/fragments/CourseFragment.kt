package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.hseapp.R
import com.example.hseapp.databinding.ActivityLoginBinding
import com.example.hseapp.databinding.FragmentCourseBinding
import com.example.hseapp.viewmodels.CourseViewModel

class CourseFragment : Fragment() {
    val viewModel by viewModels<CourseViewModel>()
    lateinit var binding: FragmentCourseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeLiveData()
        viewModel.getCourses()
        // Inflate the layout for this fragment
        binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun observeLiveData() {
        viewModel.courseData.observe(viewLifecycleOwner) {
            Log.d("Course Data",it.size.toString())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CourseFragment()
    }
}