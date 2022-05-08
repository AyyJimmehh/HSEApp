package com.example.hseapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hseapp.datamodels.Course
import com.example.hseapp.datamodels.Grade

class GradeViewModel: ViewModel() {
    var gradeData: MutableLiveData<ArrayList<Grade>> = MutableLiveData()

    fun getGrade() {
        var gradeList = ArrayList<Grade>()
        gradeList.add(Grade("16", "Venus and Mars", "10", true))
        gradeList.add(Grade("17", "Venus and Mars", "10", false))
        gradeList.add(Grade("18", "Venus and Mars", "10", false))
        gradeList.add(Grade("19", "Venus and Mars", "10", false))
        gradeList.add(Grade("20", "Venus and Mars", "10", false))
        gradeList.add(Grade("21", "Venus and Mars", "10", false))
        gradeList.add(Grade("22", "Venus and Mars", "10", false))
        gradeList.add(Grade("23", "Venus and Mars", "10", false))
        gradeList.add(Grade("24", "Venus and Mars", "10", false))
        gradeList.add(Grade("25", "Venus and Mars", "10", false))

        gradeData.value = gradeList

    }
}