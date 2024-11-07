package ro.pub.cs.systems.eim.colocviul1_1a

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        // Retrieve the instructions passed from MainActivity
        val instructions = intent.getStringExtra("INSTRUCTIONS") ?: "No instructions provided"

        // Display the instructions in the TextView
        val instructionsTextView = findViewById<TextView>(R.id.tv_instructions)
        instructionsTextView.text = instructions

        // Register button: display a Toast and return to MainActivity
        findViewById<Button>(R.id.btn_register).setOnClickListener {
            showToastAndReturn("Register button pressed")
        }

        // Cancel button: display a Toast and return to MainActivity
        findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            showToastAndReturn("Cancel button pressed")
        }
    }

    private fun showToastAndReturn(message: String) {
        // Display the Toast
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        // Return to MainActivity
        finish()
    }
}
