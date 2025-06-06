package cz.fit.cvut.biand.homework1.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import cz.fit.cvut.biand.homework1.Detail
import cz.fit.cvut.biand.homework1.R
import cz.fit.cvut.biand.homework1.SearchViewModel
import cz.fit.cvut.biand.homework1.model.Character

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    val controller = LocalSoftwareKeyboardController.current
    val viewModel = viewModel<SearchViewModel>()
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()

    SearchBar(
        inputField = {
            SearchBarDefaults.InputField(
                query = viewModel.searchQuery,
                onQueryChange = viewModel::onSearchQueryChange,
                onSearch = { controller?.hide() },
                expanded = true,
                onExpandedChange = { },
                placeholder = { Text("Search characters") },
                leadingIcon =  {
                    IconButton(onClick = {navController.navigateUp()}){
                        Icon(painter = painterResource(R.drawable.arrow_left),null, tint = MaterialTheme.colorScheme.secondary)
                    }
                },
                trailingIcon = {
                    if (viewModel.searchQuery != ""){
                        IconButton(onClick = viewModel::clearQuery){
                            Icon(painter = painterResource(R.drawable.x), null, tint = MaterialTheme.colorScheme.secondary)
                        }
                    }

                }
            )
        },
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        expanded = true,
        onExpandedChange = {  },
    ) {
        LazyColumn(modifier = Modifier
            .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(searchResults) { character ->
                SearchItem(character, navController)
            }
        }
    }
}

@Composable
fun SearchItem(character: Character, navController: NavController)
{
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate(Detail(character.id)) },
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(64.dp)

            )
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(character.name, fontWeight = FontWeight.Bold)
                Text(
                    character.status,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}