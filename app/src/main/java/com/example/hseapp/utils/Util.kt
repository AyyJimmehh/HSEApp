package com.example.hseapp.utils

object Util {
    fun isValidEmail(email:String?): Boolean {
        return !email.isNullOrEmpty()
    }

    fun isValidPassword(pass:String?): Boolean {
        return !pass.isNullOrEmpty() && pass.length > 6
    }


}