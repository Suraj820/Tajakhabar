package com.example.tajakhabar.presentation.navgraph

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tajakhabar.presentation.home.HomeScreen
import com.example.tajakhabar.presentation.home.HomeViewModel
import com.example.tajakhabar.presentation.onboarding.OnBoardingScreen
import com.example.tajakhabar.presentation.onboarding.OnBoardingViewModel
import com.example.tajakhabar.presentation.search.SearchScreen
import com.example.tajakhabar.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    
    NavHost(navController = navController , startDestination = startDestination ){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(route = Route.OnBoardingScreen.route){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable( route = Route.NewsNavigatorScreen.route){
                val viewModel:SearchViewModel = hiltViewModel()
                SearchScreen(state = viewModel.state.value, event = viewModel::onEvent, navigate = {})
            }
        }
    }
    
}