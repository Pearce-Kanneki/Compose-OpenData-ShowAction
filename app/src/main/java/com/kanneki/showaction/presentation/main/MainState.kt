package com.kanneki.showaction.presentation.main

import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.presentation.util.CategoryEnum

data class MainState(
    val category: CategoryEnum = CategoryEnum.NONE,
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: List<ShowData>? = null,
    val searchText: String = "",
    val showSelectDialog: Boolean = false
)
