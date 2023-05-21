package com.example.loginpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class VerifyQRActivity : AppCompatActivity() {

    private lateinit var statusTextView: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var verifyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)

        statusTextView = findViewById(R.id.statusTextView)
        progressBar = findViewById(R.id.progressBar)
        verifyButton = findViewById(R.id.verifyButton)

        verifyButton.setOnClickListener {
            // Show progress bar and disable the verify button
            progressBar.visibility = View.VISIBLE
            verifyButton.isEnabled = false

            // Launch QR scanner
            val integrator = IntentIntegrator(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            integrator.setPrompt("Scan QR Code")
            integrator.setBeepEnabled(false)
            integrator.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val result: IntentResult? =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents != null) {
                val scannedCode = result.contents
                val userId = "123" // User ID will be taken here

                val url = "http://172.20.10.2/codeTest/verify.php"

                val stringRequest = @SuppressLint("SetTextI18n")
                object : StringRequest(Method.POST, url,
                    Response.Listener { response ->
                        if (response == "Success") {
                            // If the scanned code matches, mark the user present
                            statusTextView.text = "Verification Successful"
                            Toast.makeText(
                                applicationContext,
                                "Attendance Registered",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // Scanned code does not match
                            statusTextView.text = "Verification Failed"
                            Toast.makeText(
                                applicationContext,
                                "Failed to Register Attendance!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        // Hide progress bar and enable the verify button
                        progressBar.visibility = View.GONE
                        verifyButton.isEnabled = true
                    },
                    Response.ErrorListener { error ->
                        // Handle error case here
                        Toast.makeText(
                            applicationContext,
                            "Internal Error Occurred!",
                            Toast.LENGTH_SHORT
                        ).show()

                        // Hide progress bar and enable the verify button
                        progressBar.visibility = View.GONE
                        verifyButton.isEnabled = true
                    }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["scannedCode"] = scannedCode
                        params["userId"] = userId
                        return params
                    }
                }

                val requestQueue = Volley.newRequestQueue(this)
                requestQueue.add(stringRequest)
            } else {
                // QR scanning canceled
                Toast.makeText(
                    applicationContext,
                    "Scan canceled",
                    Toast.LENGTH_SHORT
                ).show()

                // Hide progress bar and enable the verify button
                progressBar.visibility = View.GONE
                verifyButton.isEnabled = true
            }
        }
    }
}
