package com.example.hseapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hseapp.datamodels.Timetable

class TimetableViewModel : ViewModel() {
    var timetableData: MutableLiveData<ArrayList<Timetable>> = MutableLiveData()

    fun getTeacher() {
        var tableList = ArrayList<Timetable>()
        tableList.add(Timetable("09:30", "10:50", "LECTURE", "Optimization Methods (Eng)", "Online"))
        tableList.add(Timetable("11:10", "12:30", "LECTURE", "Machine Learning 1 (Eng)", "Online"))
        tableList.add(Timetable("09:30", "10:50", "LECTURE", "Optimization Methods (Eng)", "Online"))
        tableList.add(Timetable("11:10", "12:30", "LECTURE", "Machine Learning 1 (Eng)", "Online"))
        tableList.add(Timetable("09:30", "10:50", "LECTURE", "Optimization Methods (Eng)", "Online"))
        tableList.add(Timetable("11:10", "12:30", "LECTURE", "Machine Learning 1 (Eng)", "Online"))

        timetableData.value = tableList
    }
}