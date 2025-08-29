package com.example.a10_coding_languages.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Language(
    @StringRes val label: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
