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
import com.example.hseapp.ui.adapters.TeacherAdapter
import com.example.hseapp.viewmodels.CourseViewModel
import com.example.hseapp.viewmodels.TeacherViewModel

class CourseFragment : Fragment() {
    val courseviewModel by viewModels<CourseViewModel>()
    lateinit var coursebinding: FragmentCourseBinding
    lateinit var courseAdapter : CourseAdapter

    val teacherviewModel by viewModels<TeacherViewModel>()
    lateinit var teacherAdapter : TeacherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeLiveData()

        courseviewModel.getCourses()
        teacherviewModel.getTeacher()

        // Inflate the layout for this fragment
        coursebinding = FragmentCourseBinding.inflate(inflater, container, false)
        return coursebinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coursebinding.coursetoolbar.toolbarTitle.text = "Courses"
        coursebinding.courserecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
            false)
        courseAdapter = CourseAdapter(null)
        coursebinding.courserecycler.adapter = courseAdapter

        coursebinding.courseTeachingStaff.teacherRecycler.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        teacherAdapter = TeacherAdapter(null)
        coursebinding.courseTeachingStaff.teacherRecycler.adapter = teacherAdapter
    }

    private fun observeLiveData() {
        courseviewModel.courseData.observe(viewLifecycleOwner) {
            Log.d("Course Data",it.size.toString())
            courseAdapter.names = it
            courseAdapter.notifyDataSetChanged()
        }

        teacherviewModel.teacherData.observe(viewLifecycleOwner) {
            Log.d("Teacher Data", it.size.toString())
            teacherAdapter.names = it
            teacherAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CourseFragment()
    }
}