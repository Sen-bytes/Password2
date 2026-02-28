package com.example.password

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class PassViewModel : ViewModel(){

    private val _pass = MutableLiveData<String>()
    private val _count = MutableLiveData<Int>()
    private val _text = MutableLiveData<String>()


    val count: LiveData<Int> get() = _count
    val pass: LiveData<String> get() = _pass
    val text: LiveData<String> get() = _text

    fun setPass(pass: String) {
        _pass.value = pass
        _count.value = pass.length

        Seguridad(pass.length)

    }
    fun Seguridad(count: Int) {
        val count = pass.value?.length ?: 0
        if (count > 10) {
            _text.value = "Seguro"
        }else if (count <= 10 && count >= 5) {
            _text.value = "Media"
        }else {
            _text.value = "Debil"
        }
    }

}