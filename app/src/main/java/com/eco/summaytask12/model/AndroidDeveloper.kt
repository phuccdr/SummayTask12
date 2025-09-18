package com.eco.summaytask12.model

class AndroidDeveloper(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    position: String,
    department: String,
    var experience: Double,
    var skills: HashSet<String>,
) : Employee(name, birthOfDate, gender, address, phone, email, position, department),
    KotlinExercise {

    val level: DeveloperLevel
        get() =
            when {
                experience < 0.5 -> DeveloperLevel.INTERN
                experience < 1 -> DeveloperLevel.FRESHER
                experience < 3 -> DeveloperLevel.JUNIOR
                else -> DeveloperLevel.SENIOR
            }

    override fun greet() {
        println("Hello i am a Android Developer")
    }

    fun updateExperience(newExperience: Double) {
        this.experience = newExperience
    }

    override fun studyKotlin() {
        skills.add("Kotlin")
        skills.add("Collections")
    }

}