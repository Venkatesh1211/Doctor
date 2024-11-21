package com.example.doctor

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "DoctorDB"
        const val DATABASE_VERSION = 1
        const val TABLE_USERS = "Users"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_NAME = "name"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_EMAIL TEXT PRIMARY KEY,
                $COLUMN_NAME TEXT
            )
        """
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    // Insert User with parameterized queries
    fun insertUser(email: String, name: String) {
        val db = writableDatabase
        val query = "INSERT OR IGNORE INTO $TABLE_USERS ($COLUMN_EMAIL, $COLUMN_NAME) VALUES (?, ?)"
        db.execSQL(query, arrayOf(email, name)) // Avoid raw SQL injection
        db.close()
    }

    // Get user name by email
    fun getUser(email: String): String? {
        val db = readableDatabase
        val query = "SELECT $COLUMN_NAME FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ?"
        val cursor = db.rawQuery(query, arrayOf(email))
        var name: String? = null
        if (cursor.moveToFirst()) {
            name = cursor.getString(0)
        }
        cursor.close()
        db.close()
        return name
    }
}
