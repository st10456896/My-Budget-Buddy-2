package com.example.mybudgetbuddy

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        // Retrieve data passed from MainActivity
        val morningExpenses = intent.getDoubleArrayExtra("morningExpenses") ?: doubleArrayOf()
        val afternoonExpenses = intent.getDoubleArrayExtra("afternoonExpenses") ?: doubleArrayOf()
        val daysOfWeek = intent.getStringArrayExtra("daysOfWeek") ?: arrayOf()
        val foodItems = intent.getStringArrayExtra("foodItems") ?: arrayOf()

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val averageTextView = findViewById<TextView>(R.id.averageTextView)
        val highestExpenseButton = findViewById<Button>(R.id.highestExpenseButton)
        val backButton = findViewById<Button>(R.id.backButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Display daily details
        val detailsBuilder = StringBuilder()
        var totalExpenses = 0.0

        for (i in daysOfWeek.indices) {
            val dailyTotal = morningExpenses[i] + afternoonExpenses[i]
            totalExpenses += dailyTotal

            detailsBuilder.append(
                "${daysOfWeek[i]}:\n" +
                        "  Morning: R${morningExpenses[i]} - ${foodItems[i]}\n" +
                        "  Afternoon: R${afternoonExpenses[i]}\n" +
                        "  Daily Total: R${"%.2f".format(dailyTotal)}\n\n"
            )
        }

        detailsTextView.text = detailsBuilder.toString()

        // Calculate and display average spending
        val averageSpending = totalExpenses / daysOfWeek.size
        averageTextView.text = "Average Daily Expense: R${"%.2f".format(averageSpending)}"

        // Handle highest expense button
        highestExpenseButton.setOnClickListener {
            val maxMorning = morningExpenses.maxOrNull() ?: 0.0
            val maxAfternoon = afternoonExpenses.maxOrNull() ?: 0.0
            val highestExpense = maxOf(maxMorning, maxAfternoon)
            Toast.makeText(this, "Highest Expense: R${"%.2f".format(highestExpense)}", Toast.LENGTH_LONG).show()
        }

        // Handle back button
        backButton.setOnClickListener {
            finish() // Navigate back to MainActivity
        }

        // Handle reset button
        resetButton.setOnClickListener {
            // Reset logic (you can define more actions here if needed)
            Toast.makeText(this, "Data reset successfully!", Toast.LENGTH_SHORT).show()
        }
    }
}

