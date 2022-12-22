package com.kanneki.showaction.domain.model

import com.kanneki.showaction.data.remote.ShowDataDto

data class ShowData(
    /**
     * 辨識碼
     */
    val uid: String,
    /**
     * 活動名稱
     */
    val title: String,
    /**
     * 活動類別
     */
    val category: String,
    /**
     * 活動場次資訊
     */
    val showInfo: List<ShowInfo>,
    /**
     * 演出單位
     */
    val showUnit: String,
    /**
     * 簡介
     */
    val desc: String,
    /**
     * 主辦單位
     */
    val masterUnit: List<String>,
    /**
     * 協辦單位
     */
    val subUnit: List<String>,
    /**
     * 贊助單位
     */
    val supportUnit: List<String>,
    /**
     * 其他單位
     */
    val otherUnit: List<String>,
    /**
     * 售票網址
     */
    val webSales: String,
    /**
     * 推廣網址
     */
    val sourceWeb: String,
    /**
     * 來源網站名稱
     */
    val sourceWebName: String,
    /**
     * 備註
     */
    val comment: String,
    /**
     * 起始日期
     */
    val startDate: String,
    /**
     * 結束日期
     */
    val endDate: String
) {
    companion object {
        fun getCategoryName(id: Int?) = when (id) {
            1 -> "音樂"
            2 -> "戲劇"
            3 -> "舞蹈"
            4 -> "親子"
            5 -> "獨立音樂"
            6 -> "展覽"
            7 -> "講座"
            8 -> "電影"
            11 -> "綜藝"
            13 -> "競賽"
            14 -> "徵選"
            15 -> "其他"
            17 -> "演唱會"
            19 -> "研習課程"
            200 -> "閱讀"
            else -> ""
        }
    }
}

fun ShowDataDto.toShowData() = ShowData(
    uid = uID ?: "",
    title = title ?: "",
    category = ShowData.getCategoryName(category?.toIntOrNull()),
    showInfo = showInfo?.toShowInfoList() ?: listOf(),
    showUnit = showUnit ?: "",
    desc = descriptionFilterHtml ?: "",
    masterUnit = masterUnit ?: listOf(),
    subUnit = subUnit ?: listOf(),
    supportUnit = supportUnit ?: listOf(),
    otherUnit = otherUnit ?: listOf(),
    webSales = webSales ?: "",
    sourceWeb = sourceWebPromote ?: "",
    sourceWebName = sourceWebName ?: "",
    comment = comment ?: "",
    startDate = startDate ?: "",
    endDate = endDate ?: ""
)

fun List<ShowDataDto>.toShowDataList() = this.map { it.toShowData() }