package com.kanneki.showaction.presentation.util

enum class CategoryEnum(val id: Int, val title: String) {
    NONE(-1, ""),
    MUSIC(1, "音樂"),
    DRAMA(2, "戲劇"),
    DANCE(3, "舞蹈"),
    ARENT_CHILD(4, "親子"),
    INDEPENDENT_MUSIC(5, "獨立音樂"),
    EXHIBITION(6, "展覽"),
    CONVENTION(7, "講座"),
    MOVIE(8, "電影"),
    VARIETY_SHOW(11, "綜藝"),
    COMPETITION(13, "競賽"),
    ENLIST(14, "徵選"),
    OTHER(15, "其他"),
    CONCERT(17, "演場會"),
    STUDY_COURSE(19, "研習課程"),
    READ(200, "閱讀")
}