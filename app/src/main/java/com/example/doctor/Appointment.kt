package com.example.doctor

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Appointment : AppCompatActivity() {

    private lateinit var appointmentDetailsTextView: TextView
    private lateinit var bookAppointmentButton: Button
    private lateinit var submitAppointmentButton: Button
    private var selectedDate: String = ""
    private var selectedTime: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        appointmentDetailsTextView = findViewById(R.id.appointmentDetailsTextView)
        bookAppointmentButton = findViewById(R.id.bookAppointmentButton)
        submitAppointmentButton = findViewById(R.id.submitAppointmentButton)

        bookAppointmentButton.setOnClickListener {
            openDatePicker()
        }

        submitAppointmentButton.setOnClickListener {
            if (selectedDate.isNotEmpty() && selectedTime.isNotEmpty()) {
                Toast.makeText(this, "Appointment successfully booked for $selectedDate at $selectedTime", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please select both date and time", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                selectedDate = dateFormat.format(selectedCalendar.time)
                appointmentDetailsTextView.text = "Selected Date: $selectedDate"
                openTimePicker()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun openTimePicker() {
        val calendar = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                val timeCalendar = Calendar.getInstance()
                timeCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                timeCalendar.set(Calendar.MINUTE, minute)
                selectedTime = timeFormat.format(timeCalendar.time)
                // Display selected time in TextView
                appointmentDetailsTextView.text = "Appointment Time: $selectedDate at $selectedTime"
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }
}
