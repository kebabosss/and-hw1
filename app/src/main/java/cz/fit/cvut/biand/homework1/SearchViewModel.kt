package cz.fit.cvut.biand.homework1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.fit.cvut.biand.homework1.model.characters
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SearchViewModel : ViewModel() {
    var searchQuery by mutableStateOf("")
    private val characterFlow = flowOf(characters)
    val searchResults = characterFlow
        .map { list -> list.filter { it.name.contains(searchQuery, ignoreCase = true) } }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onSearchQueryChange(newQuery : String)
    {
        searchQuery = newQuery
    }

    fun clearQuery()
    {
        searchQuery = ""
    }
}