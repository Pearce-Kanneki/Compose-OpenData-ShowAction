package com.kanneki.showaction.presentation.detail_screen.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.R
import com.kanneki.showaction.data.preview.DemoData

@Composable
fun DetailCell(data: ShowData) {
    val uriHandler = LocalUriHandler.current

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = data.desc)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.show_unit_title, data.showUnit))
        Text(
            text = stringResource(
                id = R.string.master_unit_title,
                data.masterUnit.joinToString(separator = ",")
            )
        )
        Text(text = stringResource(id = R.string.action_date, data.startDate, data.endDate))
        Spacer(modifier = Modifier.height(8.dp))
        if (data.webSales.isNotBlank()) {
            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.web_click)),
                style = MaterialTheme.typography.subtitle1.copy(color = Color.Blue),
                onClick = {
                    uriHandler.openUri(data.webSales)
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(locale = "zh-tw",showBackground = true)
@Composable
fun DetailCellPreview() {
    DetailCell(data = DemoData.fakeShowData)
}