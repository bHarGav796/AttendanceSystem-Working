package com.example.model_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.runtime.Composable

class SplashActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        supportActionBar?.hide()

        //Animations
        val topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        val bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        //Hooks
        val image = findViewById<ImageView>(R.id.imageView)
        val logo = findViewById<TextView>(R.id.textView)
        val slogan = findViewById<TextView>(R.id.textView2)

        image.startAnimation(topAnim)
        logo.startAnimation(bottomAnim)
        slogan.startAnimation(bottomAnim)


        Handler().postDelayed({
            val intent = Intent(this, DefaultPage()::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}