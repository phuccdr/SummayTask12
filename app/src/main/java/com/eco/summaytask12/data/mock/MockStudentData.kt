package com.eco.summaytask12.data.mock

import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.internandroid.InternAndroidDeveloper

object MockStudentData {
    
    val mockStudents1: MutableSet<InternAndroidDeveloper> = mutableSetOf(
        InternAndroidDeveloper(
            "Thai Phuc",
            "20/09/2004",
            Gender.MALE,
            "Ha Noi",
            "0345527959",
            "thaiphuca1pdl@gmail.com",
            "Posts and Telecommunications Institute of Technology",
            "Software engineer",
            3.2f,
        )
    )

    val mockStudents2: HashSet<InternAndroidDeveloper> = hashSetOf(
        InternAndroidDeveloper(
            "Thai Phuc",
            "20/09/2004",
            Gender.MALE,
            "Ha Noi",
            "0345527959",
            "thaiphuca1pdl@gmail.com",
            "Posts and Telecommunications Institute of Technology",
            "Software engineer",
            3.2f,
        )
    )
}
