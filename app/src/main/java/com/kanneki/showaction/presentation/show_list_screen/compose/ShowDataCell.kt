package com.kanneki.showaction.presentation.show_list_screen.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.showaction.R
import com.kanneki.showaction.data.preview.DemoData
import com.kanneki.showaction.domain.model.ShowData

@Composable
fun ShowDataCell(modifier: Modifier, data: ShowData) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = data.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = data.showUnit, style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = R.string.action_date, data.startDate, data.endDate),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(locale = "zh-tw", showBackground = true)
@Composable
fun ShowDataCellPreview() {
    ShowDataCell(modifier = Modifier, data = DemoData.fakeShowData)
}