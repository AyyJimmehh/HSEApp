package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hseapp.ui.adapters.CourseAdapter
import com.example.hseapp.databinding.FragmentCourseBinding
import com.example.hseapp.viewmodels.CourseViewModel

class CourseFragment : Fragment() {
    val viewModel by viewModels<CourseViewModel>()
    lateinit var binding: FragmentCourseBinding
    lateinit var courseAdapter : CourseAdapter
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.coursetoolbar.toolbarTitle.text = "Courses"
        binding.courserecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
            false)
        courseAdapter = CourseAdapter(null)
        binding.courserecycler.adapter = courseAdapter


    }

    private fun observeLiveData() {
        viewModel.courseData.observe(viewLifecycleOwner) {
            Log.d("Course Data",it.size.toString())
            courseAdapter.names = it
            courseAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CourseFragment()
    }
}