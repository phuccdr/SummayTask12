package com.eco.summaytask12.data.model

open class Student(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    var university: String? = "",
    private var major: String? = "",
    private var GPA: Float = 0f,
    private var skills: HashSet<String> = hashSetOf()
) : Person(name, birthOfDate, gender, address, phone, email), KotlinExercise {
    val typeDegree: DegreeType?
        get() = when (GPA) {
            in 1.0..2.49 -> DegreeType.AVERAGE
            in 2.5..3.19 -> DegreeType.GOOD
            in 3.2..3.59 -> DegreeType.VERY_GOOD
            in 3.7..5.0 -> DegreeType.EXCELLENT
            else -> null
        }

    override fun greet() {
        println("Hello my name is $name, I am a student")
        major?.let {
            println("My major is $it")
        }
    }

    override fun run() {
        println("We're late for class, let's run!")
    }

    override fun walk() {
        println("A student is walking")
    }

    open fun study(skill: String?) = run {
        println("$name is studying")
        skill?.let {
            skills.add(it)
        }
    }

    override fun studyKotlin() {
        println("I am a student. I am studying Kotlin")
    }

    override fun toString(): String {
        return "Student(name='$name', birthOfDate='$birthOfDate', gender=$gender, address='$address', phone='$phone', email='$email', university=$university, major=$major, GPA=$GPA, skills=$skills, typeDegree=$typeDegree)"
    }

}