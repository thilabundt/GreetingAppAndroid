package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val surnameEditText: EditText = findViewById(R.id.surnameEditText)
        val customGreetingEditText: EditText = findViewById(R.id.customGreetingEditText)
        val greetingSpinner: Spinner = findViewById(R.id.greetingSpinner)
        val greetButton: Button = findViewById(R.id.greetButton)

        ArrayAdapter.createFromResource(
            this,
            R.array.greeting_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            greetingSpinner.adapter = adapter
        }

        greetingSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (parent.getItemAtPosition(position) == getString(R.string.custom_option)) {
                    customGreetingEditText.visibility = View.VISIBLE
                } else {
                    customGreetingEditText.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        greetButton.setOnClickListener {
            val customGreeting = if (customGreetingEditText.visibility == View.VISIBLE) {
                customGreetingEditText.text.toString()
            } else {
                greetingSpinner.selectedItem.toString()
            }

            val intent = Intent(this, GreetingActivity::class.java).apply {
                putExtra("NAME", nameEditText.text.toString())
                putExtra("SURNAME", surnameEditText.text.toString())
                putExtra("GREETING", customGreeting)
            }
            startActivity(intent)
        }
    }
}
