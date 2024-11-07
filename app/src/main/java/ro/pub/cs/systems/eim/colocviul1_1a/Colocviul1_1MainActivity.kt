package ro.pub.cs.systems.eim.colocviul1_1a
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class Colocviul1_1MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView
    private val buttonPressSequence = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocviul1_1_main)

        displayTextView = findViewById(R.id.tv_display)

        // Set up buttons and their click listeners
        findViewById<Button>(R.id.btn_north).setOnClickListener { addButtonText("North") }
        findViewById<Button>(R.id.btn_south).setOnClickListener { addButtonText("South") }
        findViewById<Button>(R.id.btn_east).setOnClickListener { addButtonText("East") }
        findViewById<Button>(R.id.btn_west).setOnClickListener { addButtonText("West") }
        //findViewById<Button>(R.id.btn_center).setOnClickListener { addButtonText("Center") }

        // Set up the button to open the next activity
        findViewById<Button>(R.id.btn_next_activity).setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }
    }

    private fun addButtonText(buttonText: String) {
        buttonPressSequence.add(buttonText)
        displayTextView.text = buttonPressSequence.joinToString(" -> ")
    }
}

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_next)
    }
}