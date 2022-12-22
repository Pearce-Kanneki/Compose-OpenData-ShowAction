package com.kanneki.showaction.presentation.show_list_screen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.showaction.data.preview.DemoData
import com.kanneki.showaction.domain.model.ShowData

@Composable
fun ShowDataList(list: List<ShowData>, onClick: (uid: String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(list) { data ->
            ShowDataCell(
                modifier = Modifier.clickable {
                    onClick(data.uid)
                },
                data = data
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowDataListPreview() {
    val list = listOf(DemoData.fakeShowData, DemoData.fakeShowData, DemoData.fakeShowData)
    ShowDataList(list = list, onClick = {})
}