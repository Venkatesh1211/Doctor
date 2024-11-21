package com.example.doctor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Dentist : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dentist)

        val cardDoc2 = findViewById<CardView>(R.id.cardDoc2)
        val cardDoc3 = findViewById<CardView>(R.id.cardDoc3)
        val cardDoc4 = findViewById<CardView>(R.id.cardDoc4)
        val cardDoc5 = findViewById<CardView>(R.id.cardDoc5)

        // Set OnClickListener for each CardView
        cardDoc2.setOnClickListener {
            navigateToDoctorDetail("Dr. Jane Smith")
        }
        cardDoc3.setOnClickListener {
            navigateToDoctorDetail("Dr. John Doe")
        }
        cardDoc4.setOnClickListener {
            navigateToDoctorDetail("Dr. Emily Green")
        }
        cardDoc5.setOnClickListener {
            navigateToDoctorDetail("Dr. Mark Lee")
        }
    }

    private fun navigateToDoctorDetail(doctorName: String) {
        val intent = when (doctorName) {
            "Dr. Jane Smith" -> Intent(this,john::class.java)
            "Dr. John Doe" -> Intent(this, Jake::class.java)
            "Dr. Emily Green" -> Intent(this, john::class.java)
            "Dr. Mark Lee" -> Intent(this, Jake::class.java)
            else -> throw IllegalArgumentException("Unknown doctor name")
        }
        startActivity(intent)
    }
}

