package com.example.hseapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hseapp.R

class ChatActivity : AppCompatActivity() {
    lateinit var binding:ChatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*binding = DataBindingUtil.setContentView(this,R.layout.activity_chat)
        binding..backButton.setOnClickListener {
            onBackPressed()*/
        }
    }

    //override fun onBackPressed() {
        //super.onBackPressed()
    //}
//}