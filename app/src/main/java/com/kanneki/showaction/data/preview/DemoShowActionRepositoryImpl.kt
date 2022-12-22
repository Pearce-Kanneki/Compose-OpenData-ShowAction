package com.kanneki.showaction.data.preview

import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.domain.repository.ShowActionRepository
import com.kanneki.showaction.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DemoShowActionRepositoryImpl : ShowActionRepository {

    override fun getShowAction(categoryId: Int): Flow<Resource<List<ShowData>>> {
        return flow {
            emit(
                Resource.Success(
                    listOf(
                        DemoData.fakeShowData,
                        DemoData.fakeShowData,
                        DemoData.fakeShowData
                    )
                )
            )
        }
    }
}