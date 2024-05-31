package com.example.tajakhabar.presentation.onboarding.compoenets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.tajakhabar.presentation.Dimensions.MediumPadding1
import com.example.tajakhabar.presentation.onboarding.Page

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {

    Column(modifier = modifier){
       Image(
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(fraction = 0.6f),
           painter = painterResource(id = page.image),
           contentDescription = null ,
           contentScale = ContentScale.Crop
       )
        Spacer(modifier = Modifier.height(MediumPadding1))
    }

}