package com.test

import android.os.Bundle
import android.widget.Toast
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.etDan)
        val btn = findViewById<Button>(R.id.btnEvent)
        val textResult = findViewById<TextView>(R.id.textResult)

        btn.setOnClickListener {
            val userInput = input.text.toString()

            if(userInput.isEmpty()) {
                Toast.makeText(this, "input text", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val dan = userInput.toInt()
            val result = StringBuilder()

            result.append("======$dan dan   ======\n\n")

            for (i in 1..9) {
                result.append("$dan X $i = ${dan * i}\n")
            }
            textResult.text = result.toString()
        }
    }
}