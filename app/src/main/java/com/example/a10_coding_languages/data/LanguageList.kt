package com.example.a10_coding_languages.data

import com.example.a10_coding_languages.model.Language
import com.example.a10_coding_languages.R

class LanguageList {
    fun loadList(): List<Language> {
        return listOf(
            Language(
                label = R.string.js_label,
                title = R.string.js_title,
                image = R.drawable.js,
                description = R.string.js_description
            ),
            Language(
                label = R.string.kt_label,
                title = R.string.kt_title,
                image = R.drawable.kt,
                description = R.string.kt_description
            ),
            Language(
                label = R.string.java_label,
                title = R.string.java_title,
                image = R.drawable.java_plain,
                description = R.string.java_description
            ),
            Language(
                label = R.string.c_label,
                title = R.string.c_title,
                image = R.drawable.c,
                description = R.string.c_description
            )
        )
    }
}