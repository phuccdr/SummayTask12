package com.eco.summaytask12.data.repository.datastorage

import com.eco.summaytask12.extension.stringToDate
import com.eco.summaytask12.data.model.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.backenddeveloper.BackendDeveloper
import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.manger.Manager
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.shareholder.ShareHolder

class MockEmployeeData( mockProjectData: MockProjectData,mockDeviceData: MockDeviceData) {
    val mockEmployees: MutableList<Employee> = mutableListOf(
        // ========== MANAGERS ==========
        Manager(
            name = "Tuan Nguyen",
            birthOfDate = "15/03/1985".stringToDate(),
            gender = Gender.MALE,
            address = "Cau Giay, Ha Noi",
            phone = "0912345678",
            email = "tuan.nguyen@ecomobile.com",
            department = Department.Product,
            projects = mutableListOf(
                mockProjectData.projects[0], // EcoMobile Banking App
                mockProjectData.projects[3], // Smart Home Controller
                mockProjectData.projects[6]  // Travel Booking App
            )
        ), Manager(
            name = "Mai Pham",
            birthOfDate = "22/07/1988".stringToDate(),
            gender = Gender.FEMALE,
            address = "Hai Ba Trung, Ha Noi",
            phone = "0923456789",
            email = "mai.pham@ecomobile.com",
            department = Department.Outsource,
            projects = mutableListOf(
                mockProjectData.projects[1], // E-Commerce Platform
                mockProjectData.projects[4], // Food Delivery App
                mockProjectData.projects[7]  // Social Media Dashboard
            )
        ), Manager(
            name = "Hung Le",
            birthOfDate = "10/11/1982".stringToDate(),
            gender = Gender.MALE,
            address = "Dong Da, Ha Noi",
            phone = "0934567890",
            email = "hung.le@ecomobile.com",
            department = Department.Product,
            projects = mutableListOf(
                mockProjectData.projects[2], // Health Tracking App
                mockProjectData.projects[5], // Learning Management System
                mockProjectData.projects[9]  // Video Streaming Platform
            )
        ),

        // ========== SENIOR ANDROID DEVELOPERS ==========
        AndroidDeveloper(
            name = "Phuc Thai",
            birthOfDate = "20/09/1996".stringToDate(),
            gender = Gender.MALE,
            address = "Ha Dong, Ha Noi",
            phone = "0345527959",
            email = "phucth.ecomobile@gmail.com",
            department = Department.Product,
            experience = 5.5,
            techSkills = hashSetOf(
                "Kotlin", "Java", "Android", "Jetpack Compose",
                "MVVM", "Clean Architecture", "Coroutines", "Room"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[0],
                mockDeviceData.devices[1],
                mockDeviceData.devices[2]
            )
        ),
        AndroidDeveloper(
            name = "Linh Pham",
            birthOfDate = "08/08/1995".stringToDate(),
            gender = Gender.FEMALE,
            address = "Ba Dinh, Ha Noi",
            phone = "0123456789",
            email = "linh.pham@ecomobile.com",
            department = Department.Outsource,
            experience = 6.0,
            techSkills = hashSetOf(
                "Kotlin", "Java", "Android", "Architecture",
                "Team Lead", "RxJava", "Dagger2", "Retrofit"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[3],
                mockDeviceData.devices[4],
                mockDeviceData.devices[5],
                mockDeviceData.devices[6]
            )
        ),
        AndroidDeveloper(
            name = "Hoang Tran",
            birthOfDate = "12/05/1994".stringToDate(),
            gender = Gender.MALE,
            address = "Thanh Xuan, Ha Noi",
            phone = "0945678901",
            email = "hoang.tran@ecomobile.com",
            department = Department.Product,
            experience = 7.0,
            techSkills = hashSetOf(
                "Kotlin", "Java", "Android", "Flutter",
                "Firebase", "CI/CD", "Git", "Agile"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[7],
                mockDeviceData.devices[8],
                mockDeviceData.devices[9],
                mockDeviceData.devices[10]
            )
        ),

        // ========== JUNIOR/MID ANDROID DEVELOPERS ==========
        AndroidDeveloper(
            name = "Minh Nguyen",
            birthOfDate = "25/06/1999".stringToDate(),
            gender = Gender.MALE,
            address = "Cau Giay, Ha Noi",
            phone = "0987654321",
            email = "minh.nguyen@ecomobile.com",
            department = Department.Product,
            experience = 2.5,
            techSkills = hashSetOf(
                "Kotlin", "Java", "Android", "MVVM",
                "Room", "Retrofit", "Git"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[11],
                mockDeviceData.devices[12],
                mockDeviceData.devices[13]
            )
        ),
        AndroidDeveloper(
            name = "Anh Vo",
            birthOfDate = "18/02/2000".stringToDate(),
            gender = Gender.FEMALE,
            address = "Long Bien, Ha Noi",
            phone = "0956781234",
            email = "anh.vo@ecomobile.com",
            department = Department.Outsource,
            experience = 1.8,
            techSkills = hashSetOf(
                "Kotlin", "Android", "MVVM", "Coroutines"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[14],
                mockDeviceData.devices[15]
            )
        ),
        AndroidDeveloper(
            name = "Khanh Do",
            birthOfDate = "30/09/1998".stringToDate(),
            gender = Gender.MALE,
            address = "Hoang Mai, Ha Noi",
            phone = "0967892345",
            email = "khanh.do@ecomobile.com",
            department = Department.Product,
            experience = 2.0,
            techSkills = hashSetOf(
                "Kotlin", "Java", "Android", "Material Design",
                "Navigation Component"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[16],
                mockDeviceData.devices[17]
            )
        ),

        // ========== FRESHER ANDROID DEVELOPERS ==========
        AndroidDeveloper(
            name = "Trang Nguyen",
            birthOfDate = "14/11/2001".stringToDate(),
            gender = Gender.FEMALE,
            address = "Tay Ho, Ha Noi",
            phone = "0978903456",
            email = "trang.nguyen@ecomobile.com",
            department = Department.Product,
            experience = 0.8,
            techSkills = hashSetOf(
                "Kotlin", "Android", "MVVM", "LiveData"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[18]
            )
        ),
        AndroidDeveloper(
            name = "Quan Pham",
            birthOfDate = "05/04/2002".stringToDate(),
            gender = Gender.MALE,
            address = "Gia Lam, Ha Noi",
            phone = "0989014567",
            email = "quan.pham@ecomobile.com",
            department = Department.Outsource,
            experience = 0.6,
            techSkills = hashSetOf(
                "Kotlin", "Android", "XML Layouts"
            ),
            deviceTesting = mutableListOf(
                mockDeviceData.devices[19]
            )
        ),

        // ========== BACKEND DEVELOPERS ==========
        BackendDeveloper(
            name = "Hieu Nguyen",
            birthOfDate = "20/01/1993".stringToDate(),
            gender = Gender.MALE,
            address = "Dong Da, Ha Noi",
            phone = "0991234567",
            email = "hieu.nguyen@ecomobile.com",
            department = Department.Product,
            experience = 5.0,
            techSkills = hashSetOf(
                "Java",
                "Spring Boot",
                "MySQL",
                "PostgreSQL",
                "Docker",
                "Kubernetes",
                "Microservices"
            ),
            cloudService = mutableListOf(
                "AWS EC2", "AWS RDS", "AWS Lambda", "AWS S3", "Docker Hub", "Jenkins", "Kubernetes"
            )
        ), BackendDeveloper(
            name = "Thuy Le",
            birthOfDate = "08/06/1995".stringToDate(),
            gender = Gender.FEMALE,
            address = "Cau Giay, Ha Noi",
            phone = "0902345678",
            email = "thuy.le@ecomobile.com",
            department = Department.Outsource,
            experience = 4.5,
            techSkills = hashSetOf(
                "Java", "Spring Boot", "MongoDB", "Redis", "REST API", "GraphQL"
            ),
            cloudService = mutableListOf(
                "Google Cloud Platform",
                "MongoDB Atlas",
                "Redis Cloud",
                "Firebase",
                "Google App Engine",
                "BigQuery"
            )
        ), BackendDeveloper(
            name = "Nam Vu",
            birthOfDate = "16/09/1997".stringToDate(),
            gender = Gender.MALE,
            address = "Ba Dinh, Ha Noi",
            phone = "0913456789",
            email = "nam.vu@ecomobile.com",
            department = Department.Product,
            experience = 3.0,
            techSkills = hashSetOf(
                "Java", "Python", "Django", "FastAPI", "PostgreSQL", "AWS"
            ),
            cloudService = mutableListOf(
                "Microsoft Azure",
                "Azure SQL Database",
                "Azure Functions",
                "Azure DevOps",
                "Heroku",
                "DigitalOcean"
            )
        ),


        // ========== SHAREHOLDERS ==========
        ShareHolder(
            name = "Binh Nguyen",
            birthOfDate = "15/01/1975".stringToDate(),
            gender = Gender.MALE,
            address = "Ba Dinh, Ha Noi",
            phone = "0968901234",
            email = "binh.nguyen@ecomobile.com",
            department = Department.Product,
            companyName = "EcoMobile Solutions JSC",
            sharesOwned = 35.5,
            vision = "Leading mobile technology innovation in Southeast Asia"
        ),
        ShareHolder(
            name = "Lan Pham",
            birthOfDate = "28/05/1978".stringToDate(),
            gender = Gender.FEMALE,
            address = "Hoan Kiem, Ha Noi",
            phone = "0979012345",
            email = "lan.pham@ecomobile.com",
            department = Department.Product,
            companyName = "EcoMobile Solutions JSC",
            sharesOwned = 28.0,
            vision = "Building sustainable and scalable tech solutions for Vietnam"
        ),
        ShareHolder(
            name = "Cuong Tran",
            birthOfDate = "12/11/1980".stringToDate(),
            gender = Gender.MALE,
            address = "Cau Giay, Ha Noi",
            phone = "0980123456",
            email = "cuong.tran@ecomobile.com",
            department = Department.Outsource,
            companyName = "EcoMobile Solutions JSC",
            sharesOwned = 20.5,
            vision = "Empowering businesses through digital transformation"
        ),

        // ========== REGULAR EMPLOYEES (HR, Admin, etc.) ==========
        Employee(
            name = "Hoa Nguyen",
            birthOfDate = "03/03/1990".stringToDate(),
            gender = Gender.FEMALE,
            address = "Thanh Xuan, Ha Noi",
            phone = "0345678901",
            email = "hoa.nguyen@ecomobile.com",
            department = Department.Outsource
        ),
        Employee(
            name = "Nam Tran",
            birthOfDate = "04/04/1992".stringToDate(),
            gender = Gender.MALE,
            address = "Dong Da, Ha Noi",
            phone = "0456789012",
            email = "nam.tran@ecomobile.com",
            department = Department.Product
        ),
        Employee(
            name = "Huyen Vu",
            birthOfDate = "20/08/1991".stringToDate(),
            gender = Gender.FEMALE,
            address = "Ba Dinh, Ha Noi",
            phone = "0567890123",
            email = "huyen.vu@ecomobile.com",
            department = Department.Product
        ),
        Employee(
            name = "Tai Le",
            birthOfDate = "11/06/1989".stringToDate(),
            gender = Gender.MALE,
            address = "Hoang Mai, Ha Noi",
            phone = "0678901234",
            email = "tai.le@ecomobile.com",
            department = Department.Outsource
        )
    )

    // ========== FILTERED LISTS ==========
    val mockAndroidDevelopers: List<AndroidDeveloper>
        get() = mockEmployees.filterIsInstance<AndroidDeveloper>()
    
    val mockBackendDevelopers: List<BackendDeveloper>
        get() = mockEmployees.filterIsInstance<BackendDeveloper>()
    
    val mockManagers: List<Manager>
        get() = mockEmployees.filterIsInstance<Manager>()
    
    val mockShareholders: List<ShareHolder>
        get() = mockEmployees.filterIsInstance<ShareHolder>()
    
    val mockRegularEmployees: List<Employee>
        get() = mockEmployees.filter {
            it !is AndroidDeveloper && 
            it !is BackendDeveloper &&
            it !is Manager &&
            it !is ShareHolder
        }
}
