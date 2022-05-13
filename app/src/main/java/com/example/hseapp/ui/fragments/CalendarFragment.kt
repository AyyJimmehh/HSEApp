package com.example.hseapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hseapp.databinding.FragmentCalendarBinding
import com.example.hseapp.ui.adapters.DayAdapter
import com.example.hseapp.viewmodels.CalendarViewModel


class CalendarFragment : Fragment() {
    val dayviewModel by viewModels<CalendarViewModel>()
    lateinit var dayAdapter: DayAdapter
    lateinit var calendarbinding: FragmentCalendarBinding

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
        calendarbinding.calendertoolbar.toolbarTitle.text = "Timetable"
        calendarbinding.timetable.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
            false)
        dayAdapter = DayAdapter(null)
        calendarbinding.timetable.adapter = dayAdapter

        observeLiveData()
        dayviewModel.getTimetable()
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