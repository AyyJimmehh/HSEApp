package com.example.hseapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hseapp.datamodels.Day
import com.example.hseapp.datamodels.Timetable

class CalendarViewModel : ViewModel() {
    var timetableData: MutableLiveData<ArrayList<Day>> = MutableLiveData()

    fun getTimetable() {
        var timetablelist = ArrayList<Timetable>()
        timetablelist.add(Timetable("09:30", "10:50", "LECTURE", "Optimization Methods (Eng)", "Online"))
        timetablelist.add(Timetable("11:10", "12:30", "LECTURE", "Machine Learning 1 (Eng)", "Online"))

        var tableList = ArrayList<Day>()
        tableList.add(Day("MONDAY, 10 JANUARY", timetablelist))
        tableList.add(Day("TUESDAY, 11 JANUARY", timetablelist))
        tableList.add(Day("WEDNESDAY, 12 JANUARY", timetablelist))
        tableList.add(Day("THURSDAT, 13 JANUARY", timetablelist))
        tableList.add(Day("FRIDAY, 14 JANUARY", timetablelist))

        timetableData.value = tableList
    }
}