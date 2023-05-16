package com.example.loginpage

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginpage.databinding.ActivityStudent1Binding
import com.example.loginpage.databinding.ActivityStudent2Binding
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class StudentActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityStudent2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityStudent2Binding.inflate(layoutInflater)
        setContentView(binding.root)





    }

}