package cz.fit.cvut.biand.homework1

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cz.fit.cvut.biand.homework1.screen.CharacterDetail
import cz.fit.cvut.biand.homework1.screen.CharacterList
import cz.fit.cvut.biand.homework1.screen.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
object Characters


@Serializable
object Search


@Serializable
data class Detail (val id : Int)

@Composable
fun Navigation (modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(modifier = modifier, navController = navController, startDestination = Characters)
    {
        composable<Characters> {
            CharacterList(navController)
        }
        composable<Search> {
            SearchScreen(navController, viewModel = SearchViewModel())
        }
        composable<Detail> { entry ->
            val charDetail = entry.toRoute<Detail>()
            CharacterDetail(navController, charDetail.id)
        }
    }
}
