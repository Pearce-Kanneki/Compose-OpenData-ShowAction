package com.kanneki.showaction.domain.repository

import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShowActionRepository {

    fun getShowAction(categoryId: Int): Flow<Resource<List<ShowData>>>
}