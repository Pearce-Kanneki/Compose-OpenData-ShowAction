package com.kanneki.showaction.presentation.show_list_screen.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanneki.showaction.R
import com.kanneki.showaction.presentation.util.CategoryEnum

@Composable
fun SelectDialog(
    onDismiss: (Boolean) -> Unit,
    onSelect: (CategoryEnum) -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss(false)
        },
        title = {
            Text(
                text = stringResource(id = R.string.action_category_title),
                style = MaterialTheme.typography.h5
            )
        },
        text = {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(CategoryEnum.values()) { enum ->
                    if (enum != CategoryEnum.NONE) {
                        Text(
                            text = enum.title,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onSelect(enum) }
                        )
                    }
                }
            }
        },
        confirmButton = { },
        dismissButton = {
            TextButton(onClick = { onDismiss(false) }) {
                Text(text = stringResource(id = android.R.string.cancel))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SelectDialogPreview() {
    SelectDialog(onDismiss = {}, onSelect = {})
}