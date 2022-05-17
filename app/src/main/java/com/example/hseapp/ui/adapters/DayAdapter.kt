package com.example.hseapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.databinding.CalendarDayBinding
import com.example.hseapp.datamodels.Day


class DayAdapter(var names :ArrayList<Day>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = CalendarDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DayHolder).bind(names!![position])
    }

    override fun getItemCount(): Int {
        return if (names != null)
            names!!.size
        else
            0
    }

    class DayHolder(val binding: CalendarDayBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(day: Day) {
            binding.day.text = day.day
            binding.table.layoutManager = LinearLayoutManager(
                binding.root.context, LinearLayoutManager.VERTICAL,
                false
            )
            if (day.classes != null) {
                var timetableadapter = TimetableAdapter(day.classes)
                binding.table.adapter = timetableadapter
            }

            else{}
        }
    }
}