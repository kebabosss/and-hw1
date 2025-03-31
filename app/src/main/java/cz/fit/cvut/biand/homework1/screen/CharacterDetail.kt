package cz.fit.cvut.biand.homework1.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import cz.fit.cvut.biand.homework1.Detail
import cz.fit.cvut.biand.homework1.R
import cz.fit.cvut.biand.homework1.Search
import cz.fit.cvut.biand.homework1.model.Character
import cz.fit.cvut.biand.homework1.model.characters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetail(navController: NavController, id : Int) {
    val character = characters.find {it.id == id}
    character?.let {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text(character.name,
                        fontWeight = FontWeight.Bold )
                    },
                    actions = {
                        IconButton(onClick = { })
                        {
                            Icon(painter = painterResource(id = R.drawable.star_full), contentDescription = null)
                            //TODO (star fun)
                        }
                    },
                    navigationIcon = {  IconButton(onClick = { navController.navigateUp() }) {
                        Icon(painter = painterResource(R.drawable.arrow_left), contentDescription = null)
                    }
                    }
                )
            }
        )
        { paddingValues ->
           Card (modifier = Modifier
               .padding(paddingValues)
               .padding(horizontal = 16.dp)
           )
           {
               Column (modifier = Modifier.verticalScroll(rememberScrollState())){
                   MainCard(character)
                   Column(modifier = Modifier.padding(horizontal = 16.dp),
                       verticalArrangement = Arrangement.spacedBy(16.dp)) {
                       Spacer(modifier = Modifier.padding(vertical = 8.dp))
                       InfoPair(title = stringResource(R.string.status), data = character.status)
                       InfoPair(title = stringResource(R.string.species), data = character.species)
                       InfoPair(title = stringResource(R.string.type), data = character.type)
                       InfoPair(title = stringResource(R.string.gender), data = character.gender)
                       InfoPair(title = stringResource(R.string.origin), data = character.origin)
                       InfoPair(
                           title = stringResource(R.string.location),
                           data = character.location
                       )
                       Spacer(modifier = Modifier.padding(vertical = 8.dp))
                   }
               }

           }
        }
    }
}

@Composable
fun InfoPair(title : String, data : String)
{
    var actualData = data
    Column {
        Text(title)
        if(data == "")
        {
            actualData = "-"
        }
        Text(
            actualData,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MainCard(character: Character)
{
    Card(
        modifier = Modifier
            .height(128.dp)
    )
    {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        )
        {
            AsyncImage(
                model = character.imgUrl,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier =  Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(128.dp)

            )

            InfoPair(title = stringResource(R.string.name), data = character.name)
        }

    }
}