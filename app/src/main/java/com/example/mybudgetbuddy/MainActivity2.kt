package com.example.mybudgetbuddy

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // UI functions/elements
        val inputTime: EditText = findViewById(R.id.inputTimeEditText)
        val resultText: TextView = findViewById(R.id.resultTextView)
        val suggestButton: Button = findViewById(R.id.suggestButton)
        val resetButton: Button = findViewById(R.id.resetButton)

        suggestButton.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            val suggestion = getMealSuggestion(timeOfDay)
            resultText.text = suggestion
        }

        resetButton.setOnClickListener {
            inputTime.text.clear()
            resultText.text = ""
        }
    }
    //Functions in order to get meal suggestions according to time of day
    private fun getMealSuggestion(timeOfDay: String): String {
        return if (timeOfDay == "morning") "Breakfast: Bacon"
        else if (timeOfDay == "mid-morning") "Light Snack: Apple"
        else if (timeOfDay == "afternoon") "Lunch: Sandwich"
        else if (timeOfDay == "mid-afternoon") "Quick Bite: Peanuts"
        else if (timeOfDay == "dinner") "Main Course: Pasta"
        else if (timeOfDay == "after dinner") "Dessert: Ice Cream"
        else "Invalid input. Please enter a valid time of day."
    }
}