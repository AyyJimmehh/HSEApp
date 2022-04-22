package com.example.hseapp.utils

import android.util.Patterns

object Util {
    fun isValidEmail(email:String?): Boolean {
        return !email.isNullOrEmpty() //&& Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }

    fun isValidPassword(pass:String?): Boolean {
        return !pass.isNullOrEmpty() && pass.length > 6
    }
}