package pl.trslimey.HWClick

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Show toast warning
        Toast.makeText(this@MainActivity, "WARNING: This app is experimental and created for learning purposes!", Toast.LENGTH_LONG).show()
    }

    fun onButtonClick(view: android.view.View) {
        // Increment counter
        counter += 1
        // Prepare new counter string
        var counter_string: String = counter.toString()
        if (counter == 1) { counter_string += " Click" }
        else { counter_string += " Clicks" }
        // Set counter text box to this string
        txt_counter.text = counter_string
        // Also randomly change counter color
        var colorCode: String = "#"
        for (i in 1..6) {
            colorCode += Random(counter*i).nextInt(5,12).toString(16)
        }
        // Set the random background colours
        background.setBackgroundColor(Color.parseColor(colorCode))
        btn_clicker.setBackgroundColor(Color.parseColor(colorCode))
    }

    fun writeHighScore() {
        false
    }

    fun readHighScore() {
        false
    }
}