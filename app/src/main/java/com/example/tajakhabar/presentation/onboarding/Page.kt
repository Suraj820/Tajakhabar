package com.example.tajakhabar.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.stringResource
import com.example.tajakhabar.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf<Page>(
    Page("Stay Informed, Stay Ahead", "Welcome to Tajakhabar, your one-stop destination for the latest national and international news. Get real-time updates and in-depth analysis right at your fingertips.", R.drawable.onboarding1),
    Page("News Tailored for You", "Enjoy a personalized news experience that caters to your interests. Follow your favorite topics and receive curated content that matters most to you", R.drawable.onboarding2),
    Page("Stay Updated Anytime, Anywhere", "With Tajakhabar, breaking news alerts ensure you’re always in the loop. Stay updated on the go with our user-friendly interface and offline reading mode.", R.drawable.onboarding3),
)
