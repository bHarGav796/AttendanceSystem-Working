package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.loginpage.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //making the Login button function
        binding.btnLogin.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            //if any field is empty
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //calling the validator function
            login(email, password)
        }

        //Don't Have Account Button
        binding.tvHaventAccount.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    //Body of validator function
    private fun login(email: String, password: String) {
        val url ="http://172.20.10.2/qrattendance/login.php"

        val requestQueue:RequestQueue = Volley.newRequestQueue(this)
        val stringRequest:StringRequest =object: StringRequest(Method.POST, url, { response ->
            //Intent to Dashboard Activity
            if(response.trim() == "Success"){
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, "Welcome",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Check Email and Password",Toast.LENGTH_SHORT).show()
            }

        }, { error ->
            Toast.makeText(this, error.message,Toast.LENGTH_SHORT).show()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params["email"] = email
                params["password"] = password
                return params
            }
        }
        requestQueue.add(stringRequest)
    }
}