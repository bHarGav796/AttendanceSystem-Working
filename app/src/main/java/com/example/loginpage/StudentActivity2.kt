package com.example.loginpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginpage.databinding.ActivityStudent2Binding

class StudentActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityStudent2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityStudent2Binding.inflate(layoutInflater)
        setContentView(binding.root)





    }

}