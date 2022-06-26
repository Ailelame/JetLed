package com.jetdev.jetled.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetdev.jetled.remote.LedManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val ledManager: LedManager) : ViewModel() {

    private val _isAlive = MutableLiveData<Boolean>()
    val isAlive: LiveData<Boolean> = _isAlive

    fun animateWalking() = viewModelScope.launch(Dispatchers.IO) {
        ledManager.animWalking()
    }

    fun ping() = viewModelScope.launch(Dispatchers.IO) {
        val ping = ledManager.isAlive()
        _isAlive.postValue(ping)
    }

}