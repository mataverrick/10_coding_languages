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
            )
        )
    }
}