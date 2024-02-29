// MainActivity.kt

package com.example.simple_login_app

import SignUpActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_login_app.R.id.forgot_password_text
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginBtn: Button
    private lateinit var signUpButton:Button

    // Initialize Firebase Authentication instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Authentication instance
        auth = FirebaseAuth.getInstance()

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)
        signUpButton = findViewById<Button>(R.id.signup_btn)
        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Validate input (replace with actual validation logic)
            if (isValidInput(username, password)) {
                // Perform login logic with Firebase Authentication
                signInWithEmailAndPassword(username, password)
            } else {
                // Invalid input
                Toast.makeText(this, "Please enter valid username and password", Toast.LENGTH_SHORT).show()
            }
        }

// Forgot Password Option
        val forgotPasswordText = findViewById<TextView>(forgot_password_text)
        forgotPasswordText.setOnClickListener {
            // Handle the click, for example, show a dialog or navigate to a "Forgot Password" activity
            Toast.makeText(this, "Forgot Password clicked!", Toast.LENGTH_SHORT).show()
        }

        signUpButton.setOnClickListener {
            // Navigate to signup activity
            startActivity(Intent(this, SignUpActivity::class.java))

        }
        // Inside onCreate method of MainActivity.kt



        signUpButton.setOnClickListener {
            // Navigate to signup activity
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }

    private fun isValidInput(username: String, password: String): Boolean {
        // Implement validation logic (e.g., check for empty fields, minimum length)
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        // Use Firebase Authentication to sign in with email and password
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful
                    val user: FirebaseUser? = auth.currentUser
                    Toast.makeText(this, "Welcome ${user?.email}!", Toast.LENGTH_SHORT).show()

                    // Example: Navigate to HomeActivity
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
