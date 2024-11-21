package com.example.doctor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Jake : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jake)
        val bookAppointmentButton = findViewById<Button>(R.id.bookAppointmentButton)

        bookAppointmentButton.setOnClickListener {
            val intent = Intent(this, Appointment::class.java)
            startActivity(intent)
        }
    }
}