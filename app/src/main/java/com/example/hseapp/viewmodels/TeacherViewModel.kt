package com.example.hseapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hseapp.datamodels.Teacher
import com.example.hseapp.network.RetrofitHelper
import kotlinx.coroutines.launch

class TeacherViewModel : ViewModel() {
    var teacherData: MutableLiveData<ArrayList<Teacher>> = MutableLiveData()

    fun getTeacher() {
        /*var teacherList = ArrayList<Teacher>()
        teacherList.add(Teacher("Andrey Mazhuga", "Lecturer/Seminarist", "191"))
        teacherList.add(Teacher("Galina Kaleeva", "Seminarist", "192"))
        teacherList.add(Teacher("Nikita Medved", "Seminarist", "193"))
        teacherList.add(Teacher("Steve George", "Seminarist", "194"))
        teacherList.add(Teacher("Eric George", "Seminarist", "195"))
        teacherList.add(Teacher("George Varghese", "Seminarist", "196"))

        teacherData.value = teacherList*/
    }
}