package com.eco.summaytask12.data.model.manger

import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.project.Project
import java.util.Date

class Manager(
    name: String,
    birthOfDate: Date,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    var projects: MutableList<Project> = mutableListOf()
) : Employee(name, birthOfDate, gender, address, phone, email, department) {
    fun getStatistics(): Map<String, String> {
        return projects.groupBy { project ->
            project.getStatus().toString()
        }.mapValues { (_, projects) ->
            projects.sortedByDescending { it.progress }
                .joinToString("\n") { it.name + ": " + it.progress }
        }
    }

    fun checkProjectProcess(): Map<String, List<Project>> {
        return projects.groupBy { project ->
            if (project.isCompleted) "Completed" else "Not Completed"
        }
    }

    override fun startWork() {
        getStatistics()
    }

    override fun finishWork() {
        println("Manager $name is finishing work")
    }

    override fun toString(): String {
        return "Manager(name='$name', birthOfDate='$birthOfDate', gender=$gender, address='$address', phone='$phone', email='$email', department='$department', projects=$projects)"
    }

}