package com.example.guests.repository

import android.content.ContentValues
import android.content.Context
import com.example.guests.model.GuestModel

class GuestRepository private constructor(context:Context) {

    private val guestDataBase = GuestDataBase(context)

    //singleton
    companion object{
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if(!Companion::repository.isInitialized){
            //se alguem usar o repository e tentar usar de novo não consegue inicializar outra vez
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun  insert(guest: GuestModel): Boolean{
       return try {
            val db = guestDataBase.writableDatabase

            val values = ContentValues()
            values.put("name", guest.name)
            values.put("presence", if(guest.presence) 1 else 0)

            db.insert("Guest", null,  values)

            true
        } catch (e: Exception){
            false
        }

    }

    fun update(){

    }
}