package com.example.doctor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {

    private lateinit var btnNeu: ImageButton
    private lateinit var btnCard: ImageButton
    private lateinit var btnPedi: ImageButton
    private lateinit var btnDen: ImageButton
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize the buttons
        btnNeu = findViewById(R.id.btnNeu)
        btnCard = findViewById(R.id.btncard)
        btnPedi = findViewById(R.id.btnpedi)
        btnDen = findViewById(R.id.btnDen)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, Neuro::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_location -> {
                    val intent = Intent(this, Location::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_Calendar -> {
                    val intent = Intent(this, Pediatrician::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Handle the button clicks as well (for direct navigation)
        btnNeu.setOnClickListener {
            val intent = Intent(this, Neuro::class.java)
            startActivity(intent)
        }

        btnCard.setOnClickListener {
            val intent = Intent(this, Cardiologist::class.java)
            startActivity(intent)
        }

        btnPedi.setOnClickListener {
            val intent = Intent(this, Pediatrician::class.java)
            startActivity(intent)
        }

        btnDen.setOnClickListener {
            val intent = Intent(this, Dentist::class.java)
            startActivity(intent)
        }
    }
}
