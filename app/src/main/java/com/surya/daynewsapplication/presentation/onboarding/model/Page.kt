package com.surya.daynewsapplication.presentation.onboarding.model

import androidx.annotation.DrawableRes
import com.surya.daynewsapplication.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "News Application",
        description = "To Day News App",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Daily News Application",
        description = "Read News,BookMark News for reading later, Search Based on User Preferences",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Current News",
        description = "Show List of Current Date and Time Basis News for Better Reading Experience, Stay Up To Date",
        image = R.drawable.onboarding3
    )
)