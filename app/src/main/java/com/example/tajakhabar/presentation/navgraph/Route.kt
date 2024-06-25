package com.example.tajakhabar.presentation.navgraph

sealed class Route (val route:String){
    object OnBoardingScreen: Route(route = "onBoardingScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object BookMarkScreen: Route(route = "bookMarkScreen")
    object DeatilScreen: Route(route = "detailScreen")

    object AppStartNavigation: Route(route = "appStartNavigationScreen")
    object NewsNavigation: Route(route = "newsNavigationScreen")
    object NewsNavigatorScreen: Route(route = "newsNavigatorScreen")


}