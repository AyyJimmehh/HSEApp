package com.example.hseapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hseapp.datamodels.Assignment
import com.example.hseapp.datamodels.Day
import com.example.hseapp.datamodels.Timetable
import com.example.hseapp.network.RetrofitHelper
import kotlinx.coroutines.launch

class CalendarViewModel : ViewModel() {
    var timetableData: MutableLiveData<ArrayList<Day>> = MutableLiveData()

    fun getTimetable() {
       /* var timetablelist = ArrayList<Timetable>()
        timetablelist.add(Timetable("09:30", "10:50", "LECTURE", "Optimization Methods (Eng)", "Online"))
        timetablelist.add(Timetable("11:10", "12:30", "LECTURE", "Machine Learning 1 (Eng)", "Online"))

        var tableList = ArrayList<Day>()
        tableList.add(Day("MONDAY, 10 JANUARY", timetablelist, null))
        tableList.add(Day("TUESDAY, 11 JANUARY", timetablelist, null))
        tableList.add(Day("WEDNESDAY, 12 JANUARY", timetablelist, null))
        tableList.add(Day("THURSDAT, 13 JANUARY", timetablelist, null))
        tableList.add(Day("FRIDAY, 14 JANUARY", timetablelist, null))

        timetableData.value = tableList*/

        viewModelScope.launch {
            val timetableResult = RetrofitHelper.getInstance().getTimetable()

            if (timetableResult != null) {
                timetableData.postValue(timetableResult.body()?.days)
            }
        }
    }

    fun getAssignments() {
        /*var assignmentlist = ArrayList<Assignment>()
        assignmentlist.add(Assignment("Machine Learning 1 (Eng)", "HW 14: Venus and Mars", "Till 23:59", "Submitted at 00:00"))
        assignmentlist.add(Assignment("Optimization Methods (Eng)", "HW 2: Optimizer", "Till 23:59", "Submitted at 00:00"))

        var tableList = ArrayList<Day>()
        tableList.add(Day("MONDAY, 10 JANUARY", null, assignmentlist))
        tableList.add(Day("TUESDAY, 11 JANUARY", null, assignmentlist))
        tableList.add(Day("WEDNESDAY, 12 JANUARY", null, assignmentlist))
        tableList.add(Day("THURSDAT, 13 JANUARY", null, assignmentlist))
        tableList.add(Day("FRIDAY, 14 JANUARY", null, assignmentlist))

        timetableData.value = tableList*/

        viewModelScope.launch {
            val assignmentResult = RetrofitHelper.getInstance().getAssignments()

            if (assignmentResult != null) {
                timetableData.postValue(assignmentResult.body()?.days)
            }
        }
    }
}