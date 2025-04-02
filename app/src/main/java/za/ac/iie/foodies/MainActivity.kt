package za.ac.iie.foodies

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_planner)

        // Find UI Elements by ID
        val inputTime= findViewById<EditText>(R.id.inputTIME)
        val mealOutput= findViewById<TextView>(R.id.mealOutput)
        val menuButton= findViewById<Button>(R.id.menuButton)
        val buttonReset= findViewById<Button>(R.id.buttonReset)

        // Click Button for Meal Recommendation
        menuButton.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()

            // Meal Recommendation Logic
            val mealSuggestion = when (timeOfDay) {
                "(Morning)" -> "(English Breakfast)"
                "(Mid- morning)" -> "(Granola Bar)"
                "(Afternoon)" -> "(Chicken Salad)"
                "(Mid-Afternoon)" -> "(Fruit)"
                "(Dinner)" -> "(Pasta)"
                else -> "(Invalid input)"
            }
            // Display Suggestion
            mealOutput.text = mealSuggestion
            Log.d("mealSuggestion", "User entered: $timeOfDay, Suggested meal: $mealSuggestion")
        }

        //Rest Button Functionality
        buttonReset.setOnClickListener{
            inputTime.text.clear()
            mealOutput.text=("Reset")
            Log.d("MealSuggestion", "Reset button clicked- Input Cleared")
        }
    }
}