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

class RegisterActivity: AppCompatActivity() {

    private lateinit var emailEt: EditText
    private lateinit var displayNameEt: EditText
    private lateinit var passwordEt: EditText
    private lateinit var confirmPasswordEt: EditText
    private lateinit var registerBtn: Button
    private lateinit var logInBtn: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Set views
        setViewsById()

        logInBtn.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginAcitvity::class.java))
            finish()
        }

        registerBtn.setOnClickListener {
            val email = emailEt.text.toString()
            val displayName = displayNameEt.text.toString()
            val password = passwordEt.text.toString()
            val confirmedPassword = confirmPasswordEt.text.toString()

            val validEditTextFields = (isEmailValid(email) && isDisplayNameValid(displayName) &&
                    isPasswordValid(password) && isConfirmedPasswordValid(confirmedPassword, password))

            if (validEditTextFields) {
                progressBar.visibility == View.VISIBLE

                // TODO Add logic to create a Firebase user
                // Code goes here

                progressBar.visibility = View.GONE
                startActivity(Intent(this@RegisterActivity, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun setViewsById() {
        emailEt = findViewById(R.id.email_field)
        displayNameEt = findViewById(R.id.full_name_field)
        passwordEt = findViewById(R.id.password_field)
        confirmPasswordEt = findViewById(R.id.confirm_password_field)
        registerBtn = findViewById(R.id.register_button)
        logInBtn = findViewById(R.id.login_text_button)
        progressBar = findViewById(R.id.progressbar)
    }

    private fun isEmailValid(email: String): Boolean {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this@RegisterActivity, "You must enter an email address", Toast.LENGTH_LONG).show()
            emailEt.setError("You must enter an email address")
            return false
        }
        return true
    }

    private fun isDisplayNameValid(displayName: String): Boolean {
        if (TextUtils.isEmpty(displayName)) {
            Toast.makeText(this@RegisterActivity, "You must enter your full name", Toast.LENGTH_LONG).show()
            displayNameEt.setError("You must enter your full name")
            return false
        }
        return true
    }

    private fun isPasswordValid(password: String): Boolean {
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this@RegisterActivity, "You must enter a password", Toast.LENGTH_LONG).show()
            passwordEt.setError("You must enter a password")
            return false
        }
        if (password.length < 4) {
            Toast.makeText(this@RegisterActivity, "You must enter your full name", Toast.LENGTH_LONG).show()
            passwordEt.setError("You must enter your full name")
            return false
        }
        return true
    }

    private fun isConfirmedPasswordValid(confirmedPassword: String, password: String): Boolean {
        if (!confirmedPassword.equals(password)) {
            Toast.makeText(this@RegisterActivity, "Your passwords must match", Toast.LENGTH_LONG).show()
            confirmPasswordEt.setError("Your passwords must match")
            return false
        }
        return true
    }
}
