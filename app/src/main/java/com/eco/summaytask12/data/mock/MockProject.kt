package com.eco.summaytask12.data.mock

import com.eco.summaytask12.data.model.project.Project

object MockProject {
    val projects = mutableListOf(
        Project(
            "A",
            "App android",
            "01/01/2022",
            "01/02/2022",
            100.0
        ),
        Project(
            "B",
            "App android",
            "01/01/2022",
            "01/02/2022",
            50.0
        )
    )
}