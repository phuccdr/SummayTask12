package com.eco.summaytask12.data.model.project

data class Project(
    val name:String,
    val description:String,
    val startDate:String,
    val endDate:String,
    val progress:Double
){
    val isCompleted:Boolean get() = progress>=100
}
