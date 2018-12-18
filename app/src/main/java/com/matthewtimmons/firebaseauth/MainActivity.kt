package com.matthewtimmons.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var emailTv: TextView
    private lateinit var displayNameTv: TextView
    private lateinit var logOutBtn: Button
    private lateinit var deleteAccountBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set views
        setViewsById()

        // Populate text views
        // TODO get email and display name from user
        val email = ""
        val displayName = ""
        emailTv.text = String.format("Email address: %s", email)
        displayNameTv.text = String.format("Display name: %s", displayName)


        logOutBtn.setOnClickListener {
            // TODO Log out current user before exiting activity
            // Code goes here

            startActivity(Intent(this@MainActivity, LoginAcitvity::class.java))
            finish()
        }

        deleteAccountBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this@MainActivity)

            builder.setTitle("Confirm")
                    .setMessage("Are you sure you want to delete your account? This cannot be undone.")
                    .setNegativeButton("No") { _, _ -> }
                    .setPositiveButton("Yes") {_, _ ->
                        // TODO Actually delete the user's account
                        // Code goes here

                        startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
                        finish()
                    }

            builder.create().show()
        }
    }

    fun setViewsById() {
        emailTv = findViewById(R.id.email_address_text_view)
        displayNameTv = findViewById(R.id.display_name_text_view)
        logOutBtn = findViewById(R.id.log_out_button)
        deleteAccountBtn = findViewById(R.id.delete_account_button)
    }
}
