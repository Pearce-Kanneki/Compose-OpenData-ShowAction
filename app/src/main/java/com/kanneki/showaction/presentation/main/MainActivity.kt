package com.kanneki.showaction.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kanneki.showaction.presentation.detail_screen.DetailScreen
import com.kanneki.showaction.presentation.message.MessageScreen
import com.kanneki.showaction.presentation.show_list_screen.ShowListScreen
import com.kanneki.showaction.presentation.ui.theme.ShowActionTheme
import com.kanneki.showaction.presentation.util.CategoryEnum
import com.kanneki.showaction.presentation.util.ScreenTag
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // https://data.gov.tw/dataset/6017

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowActionTheme {
                val navHostController = rememberNavController()
                val viewModel: MainViewModel = hiltViewModel()

                if (viewModel.state.category == CategoryEnum.NONE) {
                    viewModel.loadShowAction(CategoryEnum.MUSIC)
                }

                NavHost(
                    navController = navHostController,
                    startDestination = ScreenTag.showListScreen
                ) {

                    composable(ScreenTag.showListScreen) {
                        ShowListScreen(viewModel, navHostController)
                    }
                    composable(
                        "${ScreenTag.detailScreen}/{uid}",
                        arguments = listOf(
                            navArgument("uid"){
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val id = it.arguments?.getString("uid")
                        viewModel.state.data?.find { item -> item.uid == id }?.let { data ->
                            DetailScreen(navHostController, data)
                        } ?: run { 
                            MessageScreen(message = "Not Data")
                        }
                    }
                }
            }
        }
    }
}

