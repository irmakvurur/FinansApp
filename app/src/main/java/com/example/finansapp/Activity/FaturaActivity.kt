// FaturaActivity.kt
package com.example.finansapp.Activity


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finans.R
import com.example.finansapp.Activity.DatabaseHelper

class FaturaActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var faturaBilgisiInput: EditText
    private lateinit var odemeMiktariInput: EditText
    private lateinit var odemeTarihiInput: EditText
    private lateinit var odemeYapButton: Button
    private lateinit var odemeGecmisiTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fatura)

        databaseHelper = DatabaseHelper(this)

        // UI elemanlarını bağlama
        faturaBilgisiInput = findViewById(R.id.faturaBilgisiInput)
        odemeMiktariInput = findViewById(R.id.odemeMiktariInput)
        odemeTarihiInput = findViewById(R.id.odemeTarihiInput)
        odemeYapButton = findViewById(R.id.odemeYapButton)
        odemeGecmisiTextView = findViewById(R.id.odemeGecmisiTextView)

        // Ödeme yap butonuna tıklandığında
        odemeYapButton.setOnClickListener {
            val faturaBilgi = faturaBilgisiInput.text.toString()
            val odemeMiktari = odemeMiktariInput.text.toString().toDoubleOrNull()
            val odemeTarihi = odemeTarihiInput.text.toString()

            if (faturaBilgi.isEmpty() || odemeMiktari == null || odemeTarihi.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
            } else {
                val faturaId = databaseHelper.addFatura(faturaBilgi)
                if (faturaId != -1L) {
                    val odemeId = databaseHelper.addOdeme(faturaId, odemeMiktari, odemeTarihi)
                    if (odemeId != -1L) {
                        Toast.makeText(this, "Ödeme başarıyla kaydedildi", Toast.LENGTH_SHORT).show()
                        // Ödeme geçmişi metnini güncelle
                        updateOdemeGecmisi()
                    } else {
                        Toast.makeText(this, "Ödeme kaydedilemedi", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Fatura kaydedilemedi", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Ödeme geçmişini göster
        updateOdemeGecmisi()
    }

    private fun updateOdemeGecmisi() {
        // Veritabanından ödenen faturaları al ve TextView'e ekle
        val odemeGecmisi = databaseHelper.getOdenenFaturalar()
        val sb = StringBuilder()
        for (odemeBilgisi in odemeGecmisi) {
            sb.append(odemeBilgisi).append("\n")
        }
        odemeGecmisiTextView.text = sb.toString()
    }
}
