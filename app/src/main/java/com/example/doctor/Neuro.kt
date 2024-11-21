package com.example.doctor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Neuro : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neuro)
        val cardDoc2 = findViewById<CardView>(R.id.cardDoc2)
        val cardDoc3 = findViewById<CardView>(R.id.cardDoc3)
        val cardDoc4 = findViewById<CardView>(R.id.cardDoc4)
        val cardDoc5 = findViewById<CardView>(R.id.cardDoc5)

        // Set OnClickListener for each CardView
        cardDoc2.setOnClickListener {
            navigateToDoctorDetail("Dr. Danny ")
        }
        cardDoc3.setOnClickListener {
            navigateToDoctorDetail( "Dr. Charles Doe" )
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
            "Dr. Danny " -> Intent(this, Danny::class.java)
            "Dr. Charles Doe" -> Intent(this, Charles::class.java)
            "Dr. Emily Green" -> Intent(this, Danny::class.java)
            "Dr. Mark Lee" -> Intent(this, jack::class.java)
            else -> throw IllegalArgumentException("Unknown doctor name")
        }
        startActivity(intent)
    }
}

