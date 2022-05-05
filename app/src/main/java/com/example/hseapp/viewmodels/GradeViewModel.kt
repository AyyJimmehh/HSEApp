package com.example.hseapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hseapp.datamodels.Grade

class GradeViewModel: ViewModel() {
    var periodData: MutableLiveData<ArrayList<Grade>> = MutableLiveData()

    fun getPeriod() {
        var periodList = ArrayList<Grade>()
        periodList.add(Grade("Semester", true))
        periodList.add(Grade("Module", false))
        periodList.add(Grade("Type", false))
        periodList.add(Grade("Subject", false))

        periodData.value = periodList
    }
}