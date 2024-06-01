package com.example.tajakhabar.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.tajakhabar.presentation.onboarding.compoenets.OnboardingPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize()) {
        val pageState = rememberPagerState(initialPage = 0){
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> {
                        listOf("","Next")
                    }
                    1 -> {
                        listOf("Back","Next")
                    }
                    2 -> {
                        listOf("Back", "Get Started")
                    }
                    else -> { listOf("", "")}
                }
            }
        }

        HorizontalPager(state = pageState) {
            OnboardingPage(page = pages[it])
        }
    }

}