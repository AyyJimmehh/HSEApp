package com.example.hseapp.datamodels

import com.google.gson.annotations.SerializedName

data class TeacherResponse(@SerializedName("teachers") var teachers: ArrayList<Teacher>)