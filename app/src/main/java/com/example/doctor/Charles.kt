package com.example.doctor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Charles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_charles)
        val bookAppointmentButton = findViewById<Button>(R.id.bookAppointmentButton)

        bookAppointmentButton.setOnClickListener {
            val intent = Intent(this, Appointment::class.java)
            startActivity(intent)
        }
    }
}
