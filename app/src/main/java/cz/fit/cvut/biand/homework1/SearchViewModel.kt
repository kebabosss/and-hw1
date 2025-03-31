package cz.fit.cvut.biand.homework1

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.fit.cvut.biand.homework1.model.Character
import cz.fit.cvut.biand.homework1.model.characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList

class SearchViewModel : ViewModel() {
    var searchQuery by mutableStateOf("")
        private set


    private val characterFlow = flowOf(characters)

    val searchResults = snapshotFlow { searchQuery }
        .combine(characterFlow) { searchQuery, character ->
            when {
                searchQuery.isNotEmpty() -> character.filter { character ->
                    character.name.contains(searchQuery, ignoreCase = true)
                }
                else -> emptyList()
            }
        }.stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5_000)
        )

    fun onSearchQueryChange(newQuery : String)
    {
        searchQuery = newQuery
        Log.v("SEARCH", "Query has changed to $searchQuery")
    }

    fun clearQuery()
    {
        searchQuery = ""
    }
}