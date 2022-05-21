package com.example.hseapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.databinding.CalendarAssignmentBinding
import com.example.hseapp.datamodels.Assignment


class AssignmentAdapter(var names: ArrayList<Assignment>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =  CalendarAssignmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssignmentHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AssignmentHolder).bind(names!![position])
    }

    override fun getItemCount(): Int {
        return if (names != null)
            names!!.size
        else
            0
    }

    class AssignmentHolder(val binding: CalendarAssignmentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(assignment: Assignment) {
            binding.subject.text = assignment.subject
            binding.name.text = assignment.name
            binding.deadline.text = assignment.deadline
            binding.submission.text = assignment.submission

        }
    }
}