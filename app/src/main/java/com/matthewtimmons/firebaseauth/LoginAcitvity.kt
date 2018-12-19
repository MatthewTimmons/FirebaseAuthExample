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

class LoginAcitvity: AppCompatActivity() {

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var logInBtn: Button
    private lateinit var registerBtn: Button
    private lateinit var forgotPasswordBtn: Button
    private lateinit var progressbar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        // TODO Check if user has already signed in
        // Code goes here

        // Set views
        setViewsById()

        logInBtn.setOnClickListener {
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()
            val validEmailAndPassword = (isEmailValid(email) && isPasswordValid(password))

            if (validEmailAndPassword) {
                progressbar.visibility = View.VISIBLE

                // TODO Sign user into Firebase account and start Main Activity
                // Code goes here

                progressbar.visibility = View.GONE
                startActivity(Intent(this@LoginAcitvity, MainActivity::class.java))
                finish()
            }
        }

        registerBtn.setOnClickListener {
            startActivity(Intent(this@LoginAcitvity, RegisterActivity::class.java))
            finish()
        }

        forgotPasswordBtn.setOnClickListener {
            startActivity(Intent(this@LoginAcitvity, ForgotPasswordActivity::class.java))
        }
    }

    fun setViewsById() {
        emailEt = findViewById(R.id.email_field)
        passwordEt = findViewById(R.id.password_field)
        logInBtn = findViewById(R.id.login_button)
        registerBtn = findViewById(R.id.register_text_button)
        forgotPasswordBtn = findViewById(R.id.forgot_password_text_button)
        progressbar = findViewById(R.id.progressbar)
    }

    private fun isEmailValid(email: String): Boolean {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this@LoginAcitvity, "You must enter an email address", Toast.LENGTH_LONG).show()
            emailEt.setError("You must enter an email address")
            return false
        }
        return true
    }

    private fun isPasswordValid(password: String): Boolean {
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this@LoginAcitvity, "You must enter a password", Toast.LENGTH_LONG).show()
            passwordEt.setError("You must enter a password")
            return false
        }
        if (password.length < 4) {
            Toast.makeText(this@LoginAcitvity, "You must enter your full name", Toast.LENGTH_LONG).show()
            passwordEt.setError("You must enter your full name")
            return false
        }
        return true
    }
}