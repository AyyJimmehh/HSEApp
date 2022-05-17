package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hseapp.databinding.FragmentGradesBinding
import com.example.hseapp.datamodels.Course
import com.example.hseapp.datamodels.Period
import com.example.hseapp.interfaces.ItemClickListener
import com.example.hseapp.ui.adapters.GradeAdapter
import com.example.hseapp.ui.adapters.PeriodAdapter
import com.example.hseapp.viewmodels.GradeViewModel
import com.example.hseapp.viewmodels.PeriodViewModel

class GradesFragment : Fragment(), ItemClickListener {
    val periodviewModel by viewModels<PeriodViewModel>()
    lateinit var gradebinding: FragmentGradesBinding
    lateinit var periodAdapter: PeriodAdapter

    val gradeviewModel by viewModels<GradeViewModel>()
    lateinit var gradeAdapter : GradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        gradebinding = FragmentGradesBinding.inflate(inflater, container, false)
        return gradebinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        gradebinding.coursetoolbar.toolbarTitle.text = "Grades"
        gradebinding.periodrecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
            false)
        periodAdapter = PeriodAdapter(null, this)
        gradebinding.periodrecycler.adapter = periodAdapter

        gradebinding.graderecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
        false)
        gradeAdapter = GradeAdapter(null)
        gradebinding.graderecycler.adapter = gradeAdapter

        observeLiveData()

        periodviewModel.getPeriod()
        gradeviewModel.getGrade()
    }

    private fun observeLiveData() {
        periodviewModel.periodData.observe(viewLifecycleOwner) {
            Log.d("Period Data",it.size.toString())
            periodAdapter.names = it
            periodAdapter.notifyDataSetChanged()
        }

        gradeviewModel.gradeData.observe(viewLifecycleOwner) {
            Log.d("Grade Data", it.size.toString())
            gradeAdapter.names = it
            gradeAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GradesFragment()
    }

    override fun onCourseClick(obj: Course) {
    }

    override fun onPeriodClick(obj: Period) {
        Toast.makeText(activity, "Period Clicked", Toast.LENGTH_SHORT).show()
    }
}