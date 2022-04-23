package com.example.hseapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.hseapp.R
import com.example.hseapp.databinding.ActivityLoginBinding
import com.example.hseapp.utils.Constants
import com.example.hseapp.utils.Util

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private var roleSelected:String = Constants.STUDENT_ROLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        initView()

        binding.loginbutton.setOnClickListener {
            validation()
        }
    }

    fun initView() {
        binding.stud.setOnClickListener {
            roleSelected = Constants.STUDENT_ROLE
            setupButton(binding.stud, binding.assist, binding.prof)
        }

        binding.assist.setOnClickListener {
            roleSelected = Constants.ASSISTANT_ROLE
            setupButton(binding.assist, binding.stud, binding.prof)
        }

        binding.prof.setOnClickListener {
            roleSelected = Constants.PROFESSOR_ROLE
            setupButton(binding.prof, binding.assist, binding.stud)
        }
    }

    fun setupButton(selectedView:Button, view1:Button, view2:Button) {
        selectedView.background = getDrawable(R.drawable.role_background)
        selectedView.setTextColor(getColor(R.color.primary_hse_blue))

        view1.setBackgroundColor(getColor(R.color.white))
        view1.setTextColor(getColor(R.color.not_selected))

        view2.setBackgroundColor(getColor(R.color.white))
        view2.setTextColor(getColor(R.color.not_selected))
    }

    fun validation() {
        if (Util.isValidEmail(binding.login.text.toString()) && Util.isValidPassword(binding.password.text.toString())) {
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
            }
            finish()
        }
    }
}