package com.example.tajakhabar.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.tajakhabar.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf<Page>(
    Page("Title 1", "Description 1", R.drawable.onboarding1),
    Page("Title 2", "Description 2", R.drawable.onboarding2),
    Page("Title 3", "Description 3", R.drawable.onboarding3),
)
