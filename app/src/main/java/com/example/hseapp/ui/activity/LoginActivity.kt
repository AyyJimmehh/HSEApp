package com.example.hseapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

    fun setupButton(selectedView:Button, firstView:Button, secondView:Button) {
        selectedView.background = getDrawable(R.drawable.role_background)
        selectedView.setTextColor(getColor(R.color.primary_hse_blue))

        firstView.setBackgroundColor(getColor(R.color.white))
        firstView.setTextColor(getColor(R.color.not_selected))

        secondView.setBackgroundColor(getColor(R.color.white))
        secondView.setTextColor(getColor(R.color.not_selected))
    }

    fun validation() {
        val emailCheck = Util.isValidEmail(binding.login.text.toString())
        val passCheck = Util.isValidPassword(binding.password.text.toString())

        if (emailCheck && passCheck) {
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
            }
            finish()
        }
    }
}