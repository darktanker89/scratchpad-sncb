package be.kichi.sampleapp.features.announcements.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import be.johnkichi.sampleapp.models.Disturbance
import be.johnkichi.sampleapp.repository.trains.IRailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class AnnouncementsDetailViewModel @ViewModelInject constructor(
    private val repository: IRailRepository
) : ViewModel() {

    private val query = MutableStateFlow("")

    val announcement: LiveData<Disturbance> = query
        .filter { it.isNotEmpty() }
        .flatMapLatest { id -> repository.disturbance(id) }
        .filterNotNull()
        .asLiveData(viewModelScope.coroutineContext)

    fun setId(id: String) = viewModelScope.launch {
        query.value = id
    }
}
