package com.example.a2tapp_hw1

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    private var number = 0

    companion object {
        const val REQUEST_CODE_SECOND_ACTIVITY = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        if (savedInstanceState != null) {
            number = savedInstanceState.getInt("number")
        }

        showNumber()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("number", number)
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("MainActivity", "Configuration Changed")
        number += 1
        showNumber()

    }

    fun sendDataToSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("number", number)
        Log.d("MainActivity", "Go to the secondActivity")
        startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SECOND_ACTIVITY && resultCode == RESULT_OK) {
            val receivedNumber = data?.getIntExtra("number", 0)
            Log.d("MainActivity", "Received number from SecondActivity: $receivedNumber")
            if (receivedNumber != null) {
                number = receivedNumber
                showNumber()
            }
        }
    }

    private fun showNumber() {
        val textView: TextView = findViewById(R.id.textView)
        textView.text = number.toString()
        Log.d("MainActivity", "The number is equal: $number")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}
