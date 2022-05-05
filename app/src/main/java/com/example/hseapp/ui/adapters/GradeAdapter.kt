package com.example.hseapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.databinding.PeriodlistBinding
import com.example.hseapp.datamodels.Grade

class GradeAdapter(var names :ArrayList<Grade>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = PeriodlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeriodHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PeriodHolder).bind(names!![position])
    }

    override fun getItemCount(): Int {
        return if (names != null)
            names!!.size
        else
            0
    }

    class PeriodHolder(val binding: PeriodlistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(period: Grade) {
            binding.period = period
        }
    }
}