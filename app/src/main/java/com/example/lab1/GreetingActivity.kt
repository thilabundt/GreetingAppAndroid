package com.example.lab1

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetingActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val greetingTextView: TextView = findViewById(R.id.greetingTextView)
        val name = intent.getStringExtra("NAME")
        val surname = intent.getStringExtra("SURNAME")
        val greeting = intent.getStringExtra("GREETING")

        greetingTextView.text = "$greeting, $name $surname!"

        Handler(Looper.getMainLooper()).postDelayed({
            finish()
        }, 5000)
    }
}
