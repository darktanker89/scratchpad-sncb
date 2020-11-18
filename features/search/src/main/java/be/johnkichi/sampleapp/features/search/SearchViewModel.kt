package be.johnkichi.sampleapp.features.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import be.johnkichi.sampleapp.repository.trains.IRailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class SearchViewModel @ViewModelInject constructor(
    private val repository: IRailRepository
) : ViewModel() {

    private val query = MutableStateFlow("")

    val searchResult: LiveData<List<String>> = query
        .filter { it.isNotEmpty() }
        .flatMapLatest { searchText -> repository.searchStation(searchText) }
        .asLiveData(viewModelScope.coroutineContext)

    fun searchFor(searchQuery: String) = viewModelScope.launch {
        query.value = searchQuery
    }

    //        val options = repository.searchStation(searchQuery).asLiveData()
    //        _departureOptions.postValue(repository.searchStation(searchQuery).asLiveData().value)
}
