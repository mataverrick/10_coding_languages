package com.example.a10_coding_languages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a10_coding_languages.data.LanguageList
import com.example.a10_coding_languages.model.Language
import com.example.a10_coding_languages.ui.theme._10_coding_languagesTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

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
    val languages: List<Language> = LanguageList().loadList()
    Scaffold(
        modifier = modifier,
        topBar = {TopBar()}
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
                items(languages) {
                    CardLanguage(
                        it, Modifier
                            .padding(8.dp)
                            .fillMaxWidth(0.9f)
                    )
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            titleContentColor = MaterialTheme.colorScheme.onTertiary
        ),
        title = {Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineSmall
        )}
    )
}

@Composable
fun CardLanguage(language: Language, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            onClick = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .clip(RoundedCornerShape(bottomStart = 30.dp, topEnd = 30.dp))
        ) {
            Column {
                LanguageTitles(language = language, Modifier.padding(8.dp))
                LanguageImage(language, Modifier.fillMaxWidth())
                AnimatedVisibility(
                    visible = expanded,
                    enter = expandVertically(expandFrom = Alignment.Top),
                    exit = shrinkVertically(shrinkTowards = Alignment.Top)
                ) {
                    LanguageDescription(language,Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun LanguageTitles(language: Language, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(language.label),
            style = MaterialTheme.typography.labelMedium,
        )
        Text(
            text = stringResource(language.title),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun LanguageImage(language: Language, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(language.image),
            modifier = Modifier.size(120.dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun LanguageDescription(language: Language, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = stringResource(language.description),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _10_coding_languagesTheme {
        MainApp()
    }
}