package com.kanneki.showaction.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShowActionApi {

    @GET("SearchShowAction.do")
    suspend fun getShowActionData(
        @Query("method") tag: String = "doFindTypeJ",
        @Query("category") id: Int
    ): List<ShowDataDto>
}