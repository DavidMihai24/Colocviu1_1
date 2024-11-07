package ro.pub.cs.systems.eim.colocviul1_1a
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class Colocviul1_1MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView
    private val buttonPressSequence = mutableListOf<String>()
    private var cardinalPointCount = 0  // Integer member to track cardinal point selections

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul1_1_main)

        displayTextView = findViewById(R.id.tv_display)

        // Restore saved instance state if available
        if (savedInstanceState != null) {
            cardinalPointCount = savedInstanceState.getInt("cardinalPointCount", 0)
            buttonPressSequence.addAll(savedInstanceState.getStringArrayList("buttonPressSequence") ?: listOf())
            updateDisplayTextView()
        }

        // Set up listeners for each button to add text to the sequence
        findViewById<Button>(R.id.btn_north).setOnClickListener { onCardinalPointSelected("North") }
        findViewById<Button>(R.id.btn_south).setOnClickListener { onCardinalPointSelected("South") }
        findViewById<Button>(R.id.btn_east).setOnClickListener { onCardinalPointSelected("East") }
        findViewById<Button>(R.id.btn_west).setOnClickListener { onCardinalPointSelected("West") }
        findViewById<Button>(R.id.btn_center).setOnClickListener { addText("Center") }

        // Set up the button to open the next activity
        findViewById<Button>(R.id.btn_next_activity).setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }
    }

    private fun onCardinalPointSelected(buttonText: String) {
        // Increment the count for cardinal points and add text
        cardinalPointCount++
        addText(buttonText)
    }

    private fun addText(buttonText: String) {
        // Add the pressed button's text to the sequence
        buttonPressSequence.add(buttonText)
        // Update the TextView with the current sequence
        updateDisplayTextView()
    }

    private fun updateDisplayTextView() {
        displayTextView.text = buttonPressSequence.joinToString(" -> ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the number of cardinal points selected and the sequence of button presses
        outState.putInt("cardinalPointCount", cardinalPointCount)
        outState.putStringArrayList("buttonPressSequence", ArrayList(buttonPressSequence))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore the count and sequence
        cardinalPointCount = savedInstanceState.getInt("cardinalPointCount", 0)
        buttonPressSequence.clear()
        buttonPressSequence.addAll(savedInstanceState.getStringArrayList("buttonPressSequence") ?: listOf())
        updateDisplayTextView()
    }
}

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
    }
}