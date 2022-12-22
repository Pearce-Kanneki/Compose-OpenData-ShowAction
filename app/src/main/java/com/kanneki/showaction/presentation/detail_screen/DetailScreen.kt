package com.kanneki.showaction.presentation.detail_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kanneki.showaction.data.preview.DemoData
import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.presentation.detail_screen.compose.DetailCell
import com.kanneki.showaction.presentation.detail_screen.compose.DetailShowInfo

@Composable
fun DetailScreen(nav: NavHostController, data: ShowData) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = {
                Text(text = data.title)
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier.clickable { nav.popBackStack() }
                )
            },
            backgroundColor = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                DetailCell(data = data)
            }
            items(data.showInfo) {
                DetailShowInfo(data = it)
            }
        }
    }
}

@Preview(showBackground = true, name = "no show info")
@Composable
fun DetailScreenPreview() {
    val nav = rememberNavController()
    DetailScreen(nav, DemoData.fakeShowData)
}

@Preview(showBackground = true, name = "show info")
@Composable
fun DetailScreenPreview2() {
    val nav = rememberNavController()
    DetailScreen(nav, DemoData.fakeShowData.copy(showInfo = listOf(DemoData.fakeShowInfo)))
}