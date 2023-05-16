package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginpage.databinding.ActivityHomeBinding
import com.example.loginpage.databinding.ActivityStudent1Binding



class StudentActivity1 : AppCompatActivity() {

    lateinit var binding : ActivityStudent1Binding
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityStudent1Binding.inflate(layoutInflater)
        setContentView(binding.root)






    }


}