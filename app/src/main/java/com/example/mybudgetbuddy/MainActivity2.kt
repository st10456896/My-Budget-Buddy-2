package com.example.mybudgetbuddy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val dailyExpensesMorning = arrayOf(50.0, 40.0, 60.0, 30.0, 70.0, 50.0, 20.0)
    private val dailyExpensesAfternoon = arrayOf(30.0, 20.0, 40.0, 10.0, 60.0, 20.0, 10.0)
    private val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val foodItems = arrayOf(
        "Breakfast & Coffee",
        "Sandwich & Juice",
        "Snacks & Water",
        "Lunch & Dessert",
        "Pizza & Soda",
        "Pasta & Salad",
        "Burger & Fries"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.detailsButton).setOnClickListener {
            try {
                if (dailyExpensesMorning.isEmpty() || dailyExpensesAfternoon.isEmpty()) {
                    throw IllegalStateException("Expense arrays are empty.")
                }

                val intent = Intent(this, DetailedActivity::class.java).apply {
                    putExtra("morningExpenses", dailyExpensesMorning.toDoubleArray())
                    putExtra("afternoonExpenses", dailyExpensesAfternoon.toDoubleArray())
                    putExtra("daysOfWeek", daysOfWeek)
                    putExtra("foodItems", foodItems)
                }
                startActivity(intent)
            } catch (e: IllegalStateException) {
                Log.e("MainActivity", "Error navigating to Detailed Screen", e)
                Toast.makeText(this, "No expense data available. Please try again later.", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("MainActivity", "Unexpected error", e)
                Toast.makeText(this, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

