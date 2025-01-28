package com.example.finansapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.finans.R


class GiderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gider)

        val username = intent.getStringExtra("USERNAME")
        val welcomeTextView = findViewById<TextView>(R.id.welcomeText)
        welcomeTextView.text = "MERHABA $username"
    }
}