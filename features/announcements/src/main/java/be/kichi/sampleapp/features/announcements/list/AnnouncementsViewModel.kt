package be.kichi.sampleapp.features.announcements.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import be.johnkichi.sampleapp.models.Disturbance
import be.johnkichi.sampleapp.repository.trains.IRailRepository

class AnnouncementsViewModel @ViewModelInject constructor(
    private val repository: IRailRepository
) : ViewModel() {

    val announcements: LiveData<List<Disturbance>> =
        repository.disturbances().asLiveData(viewModelScope.coroutineContext)
}
