package com.surya.daynewsapplication.presentation.details.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.surya.daynewsapplication.theme.DayNewsApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "News") },
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = onBookmarkClick) {
                Icon(
                    imageVector = Icons.Filled.Bookmark,
                    contentDescription = null
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null
                )
            }
            IconButton(onClick = onBrowsingClick) {
                Icon(
                    imageVector = Icons.Filled.Public,
                    contentDescription = null
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsTopBarPreview() {
    DayNewsApplicationTheme  {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            DetailsTopBar(
                onBrowsingClick = { },
                onShareClick = { },
                onBookmarkClick = { },
                onBackClick = { }
            )
        }
    }
}