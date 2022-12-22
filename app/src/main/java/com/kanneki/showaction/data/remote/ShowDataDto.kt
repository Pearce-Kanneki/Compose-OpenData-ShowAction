package com.kanneki.showaction.data.remote


import com.google.gson.annotations.SerializedName

data class ShowDataDto(
    @SerializedName("category")
    val category: String?,
    @SerializedName("comment")
    val comment: String?,
    @SerializedName("descriptionFilterHtml")
    val descriptionFilterHtml: String?,
    @SerializedName("discountInfo")
    val discountInfo: String?,
    @SerializedName("editModifyDate")
    val editModifyDate: String?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("hitRate")
    val hitRate: Int?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("masterUnit")
    val masterUnit: List<String>?,
    @SerializedName("otherUnit")
    val otherUnit: List<String>?,
    @SerializedName("showInfo")
    val showInfo: List<ShowInfoDto>?,
    @SerializedName("showUnit")
    val showUnit: String?,
    @SerializedName("sourceWebName")
    val sourceWebName: String?,
    @SerializedName("sourceWebPromote")
    val sourceWebPromote: String?,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("subUnit")
    val subUnit: List<String>?,
    @SerializedName("supportUnit")
    val supportUnit: List<String>?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("UID")
    val uID: String?,
    @SerializedName("version")
    val version: String?,
    @SerializedName("webSales")
    val webSales: String?
)