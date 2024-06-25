package com.example.tajakhabar

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tajakhabar.domain.manager.useCase.AppEntryUseCases
import com.example.tajakhabar.presentation.navgraph.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
)  :ViewModel(){
    var splashCondition by mutableStateOf(true)
        private set
    private var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private  set

    init{
        appEntryUseCases.readAppEntry().onEach {startFromHomeScreen->
            if (startFromHomeScreen){
                startDestination = Route.NewsNavigation.route
            }else{
                startDestination = Route.AppStartNavigation.route
            }
            delay(3000)
            splashCondition = false

        }
    }


}