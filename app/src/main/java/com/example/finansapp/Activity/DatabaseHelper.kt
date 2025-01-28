package com.example.finansapp.Activity

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "FinansApp.db"

        //Kullanıcı tablosu
        private const val TABLE_NAME = "users"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"


        // Fatura tablosu
        private const val TABLE_FATURA = "fatura"
        private const val COLUMN_ID = "id"
        private const val COLUMN_BILGI = "bilgi"

        // Odeme tablosu
        private const val TABLE_ODEME = "odeme"
        private const val COLUMN_ODEME_ID = "id"
        private const val COLUMN_FATURA_ID = "fatura_id"
        private const val COLUMN_MIKTAR = "miktar"
        private const val COLUMN_TARIH = "tarih"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //Kullanıcı tablosu
        val createTableSQL = "CREATE TABLE $TABLE_NAME ($COLUMN_USERNAME TEXT PRIMARY KEY, $COLUMN_PASSWORD TEXT)"
        db?.execSQL(createTableSQL)

        // Fatura tablosu oluşturma sorgusu
        val CREATE_TABLE_FATURA = ("CREATE TABLE $TABLE_FATURA (" +
                "$COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_BILGI TEXT)")

        // Odeme tablosu oluşturma sorgusu
        val CREATE_TABLE_ODEME = ("CREATE TABLE $TABLE_ODEME (" +
                "$COLUMN_ODEME_ID INTEGER PRIMARY KEY," +
                "$COLUMN_FATURA_ID INTEGER," +
                "$COLUMN_MIKTAR REAL," +
                "$COLUMN_TARIH TEXT," +
                "FOREIGN KEY($COLUMN_FATURA_ID) REFERENCES $TABLE_FATURA($COLUMN_ID))")

        db?.execSQL(CREATE_TABLE_FATURA)
        db?.execSQL(CREATE_TABLE_ODEME)
    }
    //Kullanıcı tablosu
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Kullanıcı tablosu
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        // Tablo güncelleme işlemi gerektiğinde burada yapılır, şimdilik sadece onCreate çağrılıyor
        onCreate(db)
    }
    //Kullanıcı tablosu
    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_USERNAME, username)
        contentValues.put(COLUMN_PASSWORD, password)
        val result = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return result
    }

    // Yeni fatura ekleme metodu
    fun addFatura(bilgi: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_BILGI, bilgi)

        val id = db.insert(TABLE_FATURA, null, values)
        db.close()
        return id
    }

    //Kullanıcı tablosu
    fun checkUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_USERNAME = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(username, password))
        val count = cursor.count
        cursor.close()
        return count > 0
    }
    // Yeni ödeme ekleme metodu
    fun addOdeme(faturaId: Long, miktar: Double, tarih: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_FATURA_ID, faturaId)
        values.put(COLUMN_MIKTAR, miktar)
        values.put(COLUMN_TARIH, tarih)

        val id = db.insert(TABLE_ODEME, null, values)
        db.close()
        return id
    }

    // Ödenen faturaları getirme metodu
    fun getOdenenFaturalar(): List<String> {
        val odenenFaturalar = mutableListOf<String>()
        val selectQuery = """
        SELECT $TABLE_FATURA.$COLUMN_BILGI, $TABLE_ODEME.$COLUMN_MIKTAR
        FROM $TABLE_FATURA 
        INNER JOIN $TABLE_ODEME 
        ON $TABLE_FATURA.$COLUMN_ID = $TABLE_ODEME.$COLUMN_FATURA_ID
    """

        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        try {
            if (cursor != null && cursor.moveToFirst()) {
                val bilgiColumnIndex = cursor.getColumnIndex(COLUMN_BILGI)
                val miktarColumnIndex = cursor.getColumnIndex(COLUMN_MIKTAR)
                do {
                    if (bilgiColumnIndex != -1 && miktarColumnIndex != -1) {
                        val faturaBilgi = cursor.getString(bilgiColumnIndex)
                        val odemeMiktari = cursor.getDouble(miktarColumnIndex)
                        odenenFaturalar.add("$faturaBilgi - $odemeMiktari TL")
                    }
                } while (cursor.moveToNext())
            }
        } catch (e: Exception) {
            // Cursor işlemleri sırasında oluşabilecek istisnaları burada ele alın
            e.printStackTrace()
        } finally {
            cursor?.close()
            db.close()
        }

        return odenenFaturalar
    }
}
