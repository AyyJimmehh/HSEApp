package com.example.hseapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hseapp.datamodels.Course
import com.example.hseapp.network.RetrofitHelper
import kotlinx.coroutines.launch

class CourseViewModel:ViewModel() {
    var courseData:MutableLiveData<ArrayList<Course>> = MutableLiveData()
    //val loader: MutableLiveData<Boolean> = MutableLiveData()

    fun getCourses() {
        /*var courseList = ArrayList<Course>()
        courseList.add(Course("Linear Algebra", 120, true))
        courseList.add(Course("Time Series", 120, false))
        courseList.add(Course("Econometrics", 120, false))
        courseList.add(Course("Discrete Maths", 120, false))
        courseList.add(Course("Economics", 120, false))

        courseData.value = courseList*/

        viewModelScope.launch {
            //loader.postValue(true)
            val courseResult = RetrofitHelper.getInstance().getCourses()
            if (courseResult != null) {
                courseData.postValue(courseResult.body())
                //loader.postValue(false)
            }
        }
    }
}