package com.kanneki.showaction.data.repository

import com.kanneki.showaction.data.remote.ShowActionApi
import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.domain.model.toShowDataList
import com.kanneki.showaction.domain.repository.ShowActionRepository
import com.kanneki.showaction.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowActionRepositoryImpl @Inject constructor(
    private val api: ShowActionApi
) : ShowActionRepository {

    override fun getShowAction(categoryId: Int): Flow<Resource<List<ShowData>>> = flow {

        if (categoryId > 0) {
            emit(Resource.Loading())
            try {
                val result = api.getShowActionData(id = categoryId)
                emit(Resource.Success(data = result.toShowDataList()))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(e.message ?: "An unknown error occurred"))
            }
        } else {
            emit(Resource.Error("ID Error"))
        }
    }
}