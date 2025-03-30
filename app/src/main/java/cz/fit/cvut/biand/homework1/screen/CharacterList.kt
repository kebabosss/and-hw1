package cz.fit.cvut.biand.homework1.screen

import androidx.compose.foundation.Image

import android.content.res.Resources.Theme
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cz.fit.cvut.biand.homework1.R
import cz.fit.cvut.biand.homework1.Search
import coil.compose.AsyncImage
import cz.fit.cvut.biand.homework1.Detail
import cz.fit.cvut.biand.homework1.model.Character
import cz.fit.cvut.biand.homework1.model.characters


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterList(navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text(
                    stringResource(R.string.characters),
                    fontWeight = FontWeight.Bold )},
                actions = {
                    IconButton(onClick = { navController.navigate(Search) })
                    {
                        Icon(painter = painterResource(id = R.drawable.search), contentDescription = null)

                    }
                }
                )
        },
        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = { Icon(painter = painterResource(id = R.drawable.characters_active), contentDescription = null)},
                    label = { Text(stringResource(R.string.characters))}
                    )
                NavigationBarItem(
                    enabled = false,
                    selected = false,
                    onClick = {},
                    icon = { Icon(painter = painterResource(id = R.drawable.star_full), contentDescription = null) },
                    label = { Text(stringResource(R.string.favourites))}
                )
            }
        }
    )
    {
        LazyColumn(modifier = Modifier
            .padding(it)
            .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(characters) { character ->
                CharacterCard(navController, character)
            }
        }
    }
}
@Composable
fun CharacterCard(navController: NavController, character: Character) {
        Card(onClick = {
            navController.navigate(Detail(character.id))
        },
            modifier = Modifier.height(96.dp))
        {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                AsyncImage(
                    model = character.imgUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )

                Column {
                    Text(
                        character.name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(character.status)
                }
            }

        }
    }
