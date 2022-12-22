package com.kanneki.showaction.domain.model

import com.kanneki.showaction.data.remote.ShowInfoDto

data class ShowInfo(
    /**
     *  場地名稱
     */
    val locationName: String,
    /**
     *  地址
     */
    val location: String,
    /**
     * 是否售票
     */
    val onSales: Boolean,
    /**
     * 售票說明
     */
    val price: String,
    /**
     * 緯度
     */
    val latitude: Float,
    /**
     * 經度
     */
    val longitude: Float,
    /**
     *  單場次演出時間
     */
    val startTime: String,
    /**
     * 結束時間
     */
    val endTime: String
)

fun ShowInfoDto.toShowInfo() = ShowInfo(
    locationName = locationName ?: "",
    location = location ?: "",
    onSales = (onSales == "Y"),
    price = price ?: "",
    latitude = latitude?.toFloatOrNull() ?: -0f,
    longitude = longitude?.toFloatOrNull() ?: -0f,
    startTime = time ?: "",
    endTime = endTime ?: ""
)

fun List<ShowInfoDto>.toShowInfoList() = this.map { it.toShowInfo() }