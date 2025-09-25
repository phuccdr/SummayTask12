package com.eco.summaytask12.data.model.employee.manger

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.project.Project

class Manager(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    var projects: MutableList<Project>
) : Employee(name, birthOfDate, gender, address, phone, email, department) {
    fun addProject(project: Project) {
        projects.add(project)
    }

    fun checkProjectProcess(): Map<String, List<Project>> {
        return projects.groupBy { project ->
            if (project.isCompleted) "Completed" else "Not Completed"
        }
    }

    override fun startWork() {
        println("Manager $name is starting work")
    }

    override fun finishWork() {
        println("Manager $name is finishing work")
    }

    override fun toString(): String {
        return "Manager(name='$name', birthOfDate='$birthOfDate', gender=$gender, address='$address', phone='$phone', email='$email', department='$department', projects=$projects)"
    }

}