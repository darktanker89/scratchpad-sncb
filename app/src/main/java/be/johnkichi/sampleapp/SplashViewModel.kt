package be.johnkichi.sampleapp

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import be.johnkichi.sampleapp.repository.trains.IRailRepository

class SplashViewModel @ViewModelInject constructor(
    val railRrepository: IRailRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun get(key: String) = savedStateHandle.getLiveData<String>(key)

    fun put(key: String, value: String) = savedStateHandle.set(key, value)
}
