package cz.fit.cvut.biand.homework1.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import cz.fit.cvut.biand.homework1.R
import cz.fit.cvut.biand.homework1.model.Character
import cz.fit.cvut.biand.homework1.model.characters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetail(navController: NavController, id : Int) {
    val character = characters.find {it.id == id}
    var liked by rememberSaveable {mutableStateOf(false)}
    character?.let {
        Scaffold (
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    ),
                    title = {
                        Text(character.name,
                        fontWeight = FontWeight.Bold )
                    },
                    actions = {
                        IconButton(onClick = { liked = !liked })
                        {
                            if(liked) {
                                Icon(
                                    tint = MaterialTheme.colorScheme.primary,
                                    painter = painterResource(id = R.drawable.star_full_blue),
                                    contentDescription = null
                                )
                            }
                            else{
                                Icon(
                                    painter = painterResource(id = R.drawable.star_empty),
                                    contentDescription = null
                                )
                            }

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
           OutlinedCard (modifier = Modifier
               .padding(paddingValues)
               .padding(horizontal = 16.dp),
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
        Text(
            title,
            color = MaterialTheme.colorScheme.tertiary,
        )
        if(data == "")
        {
            actualData = "-"
        }
        Text(
            actualData,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MainCard(character: Character)
{
    OutlinedCard(
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

            Column {
                Text(
                    stringResource(R.string.name),
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 24.sp,
                )
                Text(
                    character.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                )
                Spacer(Modifier.height(40.dp))
            }
        }

    }
}
