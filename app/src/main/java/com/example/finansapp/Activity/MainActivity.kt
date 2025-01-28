package com.example.finansapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.finans.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navGelir = findViewById<TextView>(R.id.navGelir)
        val navGider = findViewById<TextView>(R.id.navGider)
        val navFatura = findViewById<TextView>(R.id.navFatura)

        navGelir.setOnClickListener {
            // Gelir sayfasına yönlendirme işlemleri
            val intent = Intent(this@MainActivity, GelirActivtiy::class.java)
            startActivity(intent)
        }

        navGider.setOnClickListener {
            // Gider sayfasına yönlendirme işlemleri
            val intent = Intent(this@MainActivity, GiderActivity::class.java)
            startActivity(intent)
        }

        navFatura.setOnClickListener {
            // Fatura sayfasına yönlendirme işlemleri
            val intent = Intent(this@MainActivity, FaturaActivity::class.java)
            startActivity(intent)
        }
    }
}
