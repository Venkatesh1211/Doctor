package com.example.doctor

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.Button

class Daryl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daryl)
        val bookAppointmentButton = findViewById<Button>(R.id.bookAppointmentButton)

        bookAppointmentButton.setOnClickListener {
            val intent = Intent(this, Appointment::class.java)
            startActivity(intent)
        }
    }
}
