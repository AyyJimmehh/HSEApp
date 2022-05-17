package com.example.hseapp.utils

import java.util.regex.Pattern

object Constants {
    const val SPLASH_DURATION:Long = 2000
    const val STUDENT_ROLE:String = "student"
    const val ASSISTANT_ROLE:String = "assistant"
    const val PROFESSOR_ROLE:String = "professor"
    const val CALENDAR_TIMETABLE:String = "Timetable"
    const val CALENDAR_ASSIGNMENT:String = "Assignments"
    val EMAIL_ADDRESS_PATTERN:Pattern = Pattern.compile(
        "\"^[A-Za-z0-9._%+-]+@edu.hse.ru\$\""
    )
}