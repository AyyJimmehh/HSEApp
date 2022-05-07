package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hseapp.databinding.FragmentGradesBinding
import com.example.hseapp.ui.adapters.GradeAdapter
import com.example.hseapp.ui.adapters.PeriodAdapter
import com.example.hseapp.viewmodels.GradeViewModel
import com.example.hseapp.viewmodels.PeriodViewModel

class GradesFragment : Fragment() {
    val periodviewModel by viewModels<PeriodViewModel>()
    lateinit var binding: FragmentGradesBinding
    lateinit var periodAdapter: PeriodAdapter

    val gradeviewModel by viewModels<GradeViewModel>()
    lateinit var gradeAdapter : GradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeLiveData()

        periodviewModel.getPeriod()
        gradeviewModel.getGrade()

        // Inflate the layout for this fragment
        binding = FragmentGradesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.coursetoolbar.toolbarTitle.text = "Grades"
        binding.periodrecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,
            false)
        periodAdapter = PeriodAdapter(null)
        binding.periodrecycler.adapter = periodAdapter

        binding.graderecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
        false)
        gradeAdapter = GradeAdapter(null)
        binding.graderecycler.adapter = gradeAdapter
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
}