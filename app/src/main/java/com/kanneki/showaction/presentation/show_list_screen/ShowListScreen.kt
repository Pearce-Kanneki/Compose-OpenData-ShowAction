package com.kanneki.showaction.presentation.show_list_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kanneki.showaction.R
import com.kanneki.showaction.data.preview.DemoShowActionRepositoryImpl
import com.kanneki.showaction.presentation.main.MainViewModel
import com.kanneki.showaction.presentation.show_list_screen.compose.LoadingList
import com.kanneki.showaction.presentation.show_list_screen.compose.SelectDialog
import com.kanneki.showaction.presentation.show_list_screen.compose.ShowDataList
import com.kanneki.showaction.presentation.util.CategoryEnum
import com.kanneki.showaction.presentation.util.ScreenTag

@Composable
fun ShowListScreen(
    viewModel: MainViewModel = hiltViewModel(),
    nav: NavHostController
) {

    val state = viewModel.state
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.08f)
                .padding(8.dp)
        ) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = (viewModel::setSearch),
                shape = RoundedCornerShape(16.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                },
                trailingIcon = {
                    if (state.searchText.isNotBlank()) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "clear",
                            modifier = Modifier.clickable { viewModel.setSearch("") }
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(.66f)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(4.dp))
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        if (state.isLoading) {
                            Toast
                                .makeText(context, R.string.is_loading_wait, Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            viewModel.setSelectDialog(true)
                        }

                    },
                shape = RoundedCornerShape(8.dp),
                elevation = 6.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = state.category.title,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "arrowDown",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }

        // Content
        if (state.isLoading) {
            LoadingList()
        } else {
            ShowDataList(list = viewModel.filterList()){
                nav.navigate("${ScreenTag.detailScreen}/$it")
            }
        }

        if (state.showSelectDialog) {
            SelectDialog(
                onDismiss = (viewModel::setSelectDialog),
                onSelect = (viewModel::loadShowAction)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowListScreenPreview() {
    val viewModel = MainViewModel(DemoShowActionRepositoryImpl())
    val nav = rememberNavController()
    viewModel.loadShowAction(CategoryEnum.MUSIC)
    ShowListScreen(viewModel, nav)
}