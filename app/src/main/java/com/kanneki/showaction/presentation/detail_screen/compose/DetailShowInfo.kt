package com.kanneki.showaction.presentation.detail_screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.showaction.R
import com.kanneki.showaction.data.preview.DemoData
import com.kanneki.showaction.domain.model.ShowInfo
import java.util.*

@Composable
fun DetailShowInfo(data: ShowInfo) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = data.startTime,
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray, RoundedCornerShape(12.dp))
                    .padding(start = 15.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = stringResource(id = R.string.location_name_title, data.locationName))
            if (data.longitude > 0 && data.latitude > 0) {
                val uri = String.format(Locale.ENGLISH, "geo:%f,%f", data.latitude, data.longitude)
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.location_title, "")) +
                            AnnotatedString(
                                data.location,
                                spanStyle = SpanStyle(color = Color.Blue)
                            ),
                    onClick = {
                        uriHandler.openUri(uri)
                    }
                )
            } else {
                Text(text = stringResource(id = R.string.location_title, data.location))
            }

            if (data.onSales) {
                Text(text = stringResource(id = R.string.price_title, data.price))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(id = R.string.end_time_title, data.endTime))
        }
    }
}

@Preview(showBackground = true, name = "Price")
@Composable
fun DetailShowInfoPreview() {
    DetailShowInfo(data = DemoData.fakeShowInfo)
}

@Preview(showBackground = true, name = "no Price")
@Composable
fun DetailShowInfoPreview2() {
    DetailShowInfo(data = DemoData.fakeShowInfo.copy(onSales = false))
}

@Preview(showBackground = true, name = "location")
@Composable
fun DetailShowInfoPreview3() {
    DetailShowInfo(data = DemoData.fakeShowInfo.copy(longitude = 45.5f, latitude = 99.8f))
}