package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hseapp.R
import com.example.hseapp.databinding.FragmentCourseBinding
import com.example.hseapp.databinding.FragmentGradesBinding
import com.example.hseapp.ui.adapters.CourseAdapter
import com.example.hseapp.ui.adapters.GradeAdapter
import com.example.hseapp.viewmodels.GradeViewModel

class GradesFragment : Fragment() {
    val viewModel by viewModels<GradeViewModel>()
    lateinit var binding: FragmentGradesBinding
    lateinit var gradeAdapter: GradeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeLiveData()
        viewModel.getPeriod()
        // Inflate the layout for this fragment
        binding = FragmentGradesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.coursetoolbar.toolbarTitle.text = "Grades"
        binding.periodrecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
            false)
        gradeAdapter = GradeAdapter(null)
        binding.periodrecycler.adapter = gradeAdapter


    }

    private fun observeLiveData() {
        viewModel.periodData.observe(viewLifecycleOwner) {
            Log.d("Period Data",it.size.toString())
            gradeAdapter.names = it
            gradeAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GradesFragment()
    }
}