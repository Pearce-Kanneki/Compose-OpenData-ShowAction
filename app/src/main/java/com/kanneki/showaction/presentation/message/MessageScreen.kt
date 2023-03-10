package com.kanneki.showaction.presentation.message

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MessageScreen(message: String) {
    Box(modifier = Modifier.fillMaxSize(), Alignment.Center) {
        Text(text = message, style = MaterialTheme.typography.h5)
    }
}