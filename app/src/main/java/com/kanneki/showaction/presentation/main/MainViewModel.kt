package com.kanneki.showaction.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.domain.repository.ShowActionRepository
import com.kanneki.showaction.domain.util.Resource
import com.kanneki.showaction.presentation.util.CategoryEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ShowActionRepository
) : ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    /**
     * 變更搜尋文字
     */
    fun setSearch(value: String) {
        state = state.copy(searchText = value)
    }

    /**
     * 篩選後後的資料
     */
    fun filterList(): List<ShowData> {
        return if (state.searchText.isBlank()) {
            state.data ?: listOf()
        } else {
            state.data?.filter { it.title.contains(state.searchText) } ?: listOf()
        }
    }

    /**
     * Dialog顯示控制
     */
    fun setSelectDialog(value: Boolean) {
        state = state.copy(showSelectDialog = value)
    }

    /**
     * 獲取資料
     */
    fun loadShowAction(category: CategoryEnum) {
        viewModelScope.launch {
            state = state.copy(category = category, showSelectDialog = false)
            repository.getShowAction(category.id).collect { result ->
                state = when (result) {
                    is Resource.Loading -> state.copy(isLoading = true, error = null, data = null)
                    is Resource.Success -> state.copy(
                        isLoading = false,
                        error = null,
                        data = result.data
                    )
                    is Resource.Error -> state.copy(
                        isLoading = false,
                        error = result.message,
                        data = null
                    )
                }
            }
        }
    }
}