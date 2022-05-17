package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hseapp.R
import com.example.hseapp.databinding.FragmentCalendarBinding
import com.example.hseapp.ui.adapters.DayAdapter
import com.example.hseapp.utils.Constants
import com.example.hseapp.viewmodels.CalendarViewModel


class CalendarFragment : Fragment() {
    val dayviewModel by viewModels<CalendarViewModel>()
    lateinit var dayAdapter: DayAdapter
    lateinit var calendarbinding: FragmentCalendarBinding

    var isTimetableSelected: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        calendarbinding = FragmentCalendarBinding.inflate(inflater, container, false)
        return calendarbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        calendarbinding.timetable.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
            false)
        dayAdapter = DayAdapter(null)
        calendarbinding.timetable.adapter = dayAdapter

        observeLiveData()
        dayviewModel.getTimetable()
        setupToolbar()
    }

    private fun setupToolbar() {
        calendarbinding.calendertoolbar.toolbarTitle.text = Constants.CALENDAR_TIMETABLE
        calendarbinding.calendertoolbar.secondTitle.text = Constants.CALENDAR_ASSIGNMENT

        calendarbinding.calendertoolbar.toolbarTitle.setOnClickListener {
            onTitleClick()
        }

        calendarbinding.calendertoolbar.secondTitle.setOnClickListener {
            onSecondTitleClick()
        }
    }

    private fun onSecondTitleClick() {
        isTimetableSelected = !isTimetableSelected
        if(isTimetableSelected) {
            calendarbinding.calendertoolbar.toolbarTitle.text = Constants.CALENDAR_TIMETABLE
            calendarbinding.calendertoolbar.secondTitle.text = Constants.CALENDAR_ASSIGNMENT
            dayviewModel.getTimetable()
        }
        else {
            calendarbinding.calendertoolbar.toolbarTitle.text = Constants.CALENDAR_ASSIGNMENT
            calendarbinding.calendertoolbar.secondTitle.text =  Constants.CALENDAR_TIMETABLE
            dayviewModel.getAssignments()
        }
        calendarbinding.calendertoolbar.toolbarTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0, 0, R.drawable.ic_arrow_side, 0)
        calendarbinding.calendertoolbar.secondTitle.visibility = View.GONE
    }

    private fun onTitleClick() {
        if(calendarbinding.calendertoolbar.secondTitle.isVisible) {
            calendarbinding.calendertoolbar.secondTitle.visibility = View.GONE
            calendarbinding.calendertoolbar.toolbarTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0, 0, R.drawable.ic_arrow_side, 0)
        }
        else {
            calendarbinding.calendertoolbar.secondTitle.visibility = View.VISIBLE
            calendarbinding.calendertoolbar.toolbarTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0, 0, R.drawable.ic_arrow_down, 0)
        }
        //Change drawable icon to downwards arrow dynamically

    }


    private fun observeLiveData() {
        dayviewModel.timetableData.observe(viewLifecycleOwner) {
            Log.d("Period Data", it.size.toString())
            dayAdapter.names = it
            dayAdapter.notifyDataSetChanged()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CalendarFragment()
    }
}