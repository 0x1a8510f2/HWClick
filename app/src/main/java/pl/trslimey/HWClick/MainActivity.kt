package pl.trslimey.HWClick

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.content.SharedPreferences
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class MainActivity : AppCompatActivity() {
    // Create score counter
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get shared preferences
        val sharedPrefs = getSharedPreferences("pl.trslimey.HWClick.save", Context.MODE_PRIVATE)
        // Get current high score
        val currentHighScore = sharedPrefs.getInt("currentHighScore", 0)
        // Display high score if exists
        if (currentHighScore > 0) { txt_highscore.text = currentHighScore.toString() }

        // Show toast warning
        Toast.makeText(this@MainActivity, "WARNING: This app is experimental and created for learning purposes!", Toast.LENGTH_LONG).show()
    }

    fun onClickerClick(view: android.view.View) {
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
        for (i in 1..6) { colorCode += Random(counter*i).nextInt(5,12).toString(16) }
        // Set the random background colours
        background.setBackgroundColor(Color.parseColor(colorCode))
        btn_clicker.setBackgroundColor(Color.parseColor(colorCode))
        // Get shared preferences
        val sharedPrefs = getSharedPreferences("pl.trslimey.HWClick.save", Context.MODE_PRIVATE)
        // Get current high score
        val currentHighScore = sharedPrefs.getInt("currentHighScore", 0)
        // Update highscore if needs be
        if (currentHighScore < counter) {
            val sharedPrefsEditor = sharedPrefs.edit()
            sharedPrefsEditor.putInt("currentHighScore", counter)
            sharedPrefsEditor.apply()
            txt_highscore.text = counter.toString()
        }
    }

}