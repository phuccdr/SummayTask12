package com.eco.summaytask12.data.model.manger

import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.project.Project
import com.eco.summaytask12.data.model.project.StatusProject
import java.util.Date
import java.util.Locale

class Manager(
    name: String,
    birthOfDate: Date,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    var projects: MutableList<Project>
) : Employee(name, birthOfDate, gender, address, phone, email, department) {

    fun getStatistics(): Map<StatusProject, List<Project>> {
        return projects.groupBy { project ->
            project.getStatus()
        }.mapValues {
            projects
            projects.sortedByDescending { project ->
                project.progress
            }
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