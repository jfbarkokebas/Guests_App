package com.example.guests.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

        companion object{
            private const val NAME = "guestdb"
            private const val VERSION = 1

        }

    override fun onCreate(db: SQLiteDatabase) {
        //criação do banco
        db.execSQL("CREATE TABLE Guest(" +            //criar a tabela guest com as colunas:
                "id integer primary key autoincrement," + //id - tipo integer PK autoincrementado
                " name text, " +                          // nome - tipo texto
                "presence integer)")                      // presence - tipo boolean
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}