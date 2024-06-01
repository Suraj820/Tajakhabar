package com.example.tajakhabar.presentation.onboarding.compoenets

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tajakhabar.R
import com.example.tajakhabar.presentation.Dimensions.MediumPadding1
import com.example.tajakhabar.presentation.Dimensions.MediumPadding2
import com.example.tajakhabar.presentation.onboarding.Page
import com.example.tajakhabar.presentation.onboarding.pages
import com.example.tajakhabar.ui.theme.TajaKhabarTheme

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
        Text(
            text = page.title,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            color = colorResource(id = R.color.display_small)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            color = colorResource(id = R.color.text_medium)
        )

    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun OnboardingPagePreview () {
    TajaKhabarTheme {
        OnboardingPage(page = pages.first())
    }
}