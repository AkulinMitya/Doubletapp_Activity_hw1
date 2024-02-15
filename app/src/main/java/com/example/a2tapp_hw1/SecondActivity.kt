package com.example.a2tapp_hw1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {
    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity", "onCreate")

        number = intent.getIntExtra("number", 0)
        Log.d("SecondActivity", "Received number: $number")

        val textViewSquare: TextView = findViewById(R.id.textViewSquare)
        textViewSquare.text = (number * number).toString()
        number *= number
        Log.d("SecondActivity", "The square of the number is: $number")

    }

    fun goToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("number", number)
        setResult(RESULT_OK, intent)
        Log.d("SecondActivity", "Go to the MainActivity")
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SecondActivity", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy")
    }

}


