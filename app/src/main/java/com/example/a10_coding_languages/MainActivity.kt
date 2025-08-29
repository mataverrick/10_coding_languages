package com.example.a10_coding_languages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a10_coding_languages.ui.theme._10_coding_languagesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _10_coding_languagesTheme {
                MainApp(Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier, topBar = {},
        content = { paddingValues ->
            ListLanguage(modifier = Modifier.padding(paddingValues))
        }
    )
}


@Composable
fun ListLanguage(modifier: Modifier) {
    Text(
        "hola"
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _10_coding_languagesTheme {
        MainApp()
    }
}