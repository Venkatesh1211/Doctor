package com.example.doctor

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class Login : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signupTextView: TextView
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.etEmail)
        passwordEditText = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.btnLogin)
        signupTextView = findViewById(R.id.tvSignup)

        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Validation
            if (username.isEmpty()) {
                usernameEditText.error = "Username cannot be empty"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                passwordEditText.error = "Password cannot be empty"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                usernameEditText.error = "Please enter a valid email address"
                return@setOnClickListener
            }
            if (password.length < 8) {
                passwordEditText.error = "Password must be at least 8 characters"
                return@setOnClickListener
            }

            // Firebase login
            firebaseAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // On successful login
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Home::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // On failure - detailed error handling
                        val errorMessage = when (task.exception) {
                            is FirebaseAuthInvalidCredentialsException -> "Invalid credentials. Please check your email or password."
                            is FirebaseAuthInvalidUserException -> "User not found. Please sign up."
                            else -> task.exception?.localizedMessage ?: "Login failed"
                        }
                        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
        }

        signupTextView.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
    }
}
