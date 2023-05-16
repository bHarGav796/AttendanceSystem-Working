package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.loginpage.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //making the registration button function
        binding.btnRegister.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            val fullname: String = binding.etFullname.text.toString()
            val username = binding.etUsername.text.toString()
            val email = binding.etEmail.text.toString()
            val password= binding.etPassword.text.toString()
            val confirmPassword= binding.etConfirmPassword.text.toString()

            //if any field is empty
            if (fullname.isEmpty() || username.isEmpty() ||email.isEmpty() || password.isEmpty()|| confirmPassword.isEmpty()){
                Toast.makeText(this,"Please enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //calling the validator function
            register(fullname, username, email, password)

        }
        //Already have account button
        binding.tvHaveAccount.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    //Body of validator function
    private fun register(
        fullname: String,
        username: String,
        email: String,
        password: String
    ) {
        val url ="http://172.20.10.2/qrattendance/register.php"

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val stringRequest: StringRequest =object: StringRequest(Method.POST, url, { response ->
            //Intent to Dashboard Activity
            if(response.trim() == "Success"){
                startActivity(Intent(this, HomeActivity::class.java))
                Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, "Entered email already in use", Toast.LENGTH_SHORT).show()
            }

        }, { error ->
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
        }){
            override fun getParams(): MutableMap<String, String> {
                val params=HashMap<String,String>()
                params["fullname"] = fullname
                params["username"] = username
                params["email"] = email
                params["password"] = password
                return params
            }
        }
        requestQueue.add(stringRequest)
    }
}