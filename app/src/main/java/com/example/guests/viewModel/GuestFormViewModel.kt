package com.example.guests.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guests.model.GuestModel
import com.example.guests.repository.GuestRepository

/*
  Não somos nós quem instanciamos a viewModel, é o metodo get() na ACTVITY,
* por isso não podemos passar o contexto no construtor. Sendo assim, em vez de extender
* a classe viewModel de de ViewModel(), extendemos de AndroidViewModel(application):
*/
class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private var _text = MutableLiveData<String>()
            val text: LiveData<String> = _text

    fun insert(guest: GuestModel){
        repository.insert(guest)

    }
}