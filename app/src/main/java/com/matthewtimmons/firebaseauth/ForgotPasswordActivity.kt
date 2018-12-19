package com.matthewtimmons.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

class ForgotPasswordActivity: AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var sendBtn: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        // Set views
        setViewsById()

        sendBtn.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            val email = emailEditText.text.toString()

            if (isEmailValid(email)) {
                // TODO Send email with password reset link to the user
                // Code goes here

                progressBar.visibility = View.GONE
                Toast.makeText(this@ForgotPasswordActivity, "Email has been sent", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@ForgotPasswordActivity, LoginAcitvity::class.java))
                finish()
            }
        }
    }

    private fun setViewsById() {
        emailEditText = findViewById(R.id.email_field)
        sendBtn = findViewById(R.id.send_email_button)
        progressBar = findViewById(R.id.progressbar)
    }

    private fun isEmailValid(email: String): Boolean {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this@ForgotPasswordActivity, "You must enter an email addres", Toast.LENGTH_LONG).show()
            emailEditText.setError("You must enter an email address")
            return false
        }
        return true
    }
}