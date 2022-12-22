package com.kanneki.showaction.data.remote


import com.google.gson.annotations.SerializedName

data class ShowInfoDto(
    @SerializedName("endTime")
    val endTime: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("locationName")
    val locationName: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("onSales")
    val onSales: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("time")
    val time: String?
)