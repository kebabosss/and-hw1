package cz.fit.cvut.biand.homework1.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import cz.fit.cvut.biand.homework1.R
import cz.fit.cvut.biand.homework1.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel) {
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = viewModel.searchQuery,
                onQueryChange = viewModel::onSearchQueryChange,
                onSearch = {  },
                expanded = true,
                onExpandedChange = { },
                placeholder = { Text("Search characters") },
                leadingIcon =  {
                    IconButton(onClick = {navController.navigateUp()}){
                        Icon(painter = painterResource(R.drawable.arrow_left),null,)
                    }
                },
                trailingIcon = {
                    IconButton(onClick = viewModel::clearQuery){
                        Icon(painter = painterResource(R.drawable.x), null)
                    }

                }
            )
        },
        expanded = true,
        onExpandedChange = {  },
    ) {
    }
}