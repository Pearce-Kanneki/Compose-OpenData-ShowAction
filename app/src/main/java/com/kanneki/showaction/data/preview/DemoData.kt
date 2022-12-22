package com.kanneki.showaction.data.preview

import com.kanneki.showaction.domain.model.ShowData
import com.kanneki.showaction.domain.model.ShowInfo

object DemoData {

    val fakeShowData = ShowData(
        "",
        "title",
        "1",
        listOf(),
        "show unit",
        "desc",
        listOf(),
        listOf(),
        listOf(),
        listOf(),
        "web",
        "source",
        "web name",
        "",
        "2022/12/22",
        "2022/12/22"
    )

    val fakeShowInfo = ShowInfo(
        locationName = "location name",
        location =  "location",
        onSales = true,
        price = "300,400,500",
        latitude = 0f,
        longitude = 0f,
        startTime = "2022/12/22 09:00",
        endTime = "2022/12/22 18:00"
    )
}