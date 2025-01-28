package com.example.finansapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.finans.R

class SigninActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        databaseHelper = DatabaseHelper(this)

        val textViewLoginLink = findViewById<TextView>(R.id.textViewLoginLink)
        textViewLoginLink.setOnClickListener {
            navigateToLoginActivity()
        }

        val buttonLogin = findViewById<Button>(R.id.buttonSignup)
        buttonLogin.setOnClickListener {
            navigateToMainActivity()
        }

        val buttonSignup = findViewById<Button>(R.id.buttonSignup)
        val usernameEditText = findViewById<EditText>(R.id.editTextUsername)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)


        buttonSignup.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Kullanıcı adı veya şifre boş olamaz", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = databaseHelper.addUser(username, password)
            if (result != -1L) {
                // Başarıyla eklendi, ana ekrana yönlendirme
                val intent = Intent(this, GelirActivtiy::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish()
                navigateToMainActivity()
            } else {
                // Eklenemedi, hata mesajı gösterebilirsiniz
                Toast.makeText(this, "Kayıt işlemi başarısız", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
