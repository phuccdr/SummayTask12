# SummayTask12 - Employee & Project Management System

## Mô tả ngắn gọn

**SummayTask12** là một ứng dụng Android được viết bằng Kotlin, cung cấp hệ thống quản lý nhân viên
và dự án cho doanh nghiệp. Ứng dụng sử dụng giao diện console để tương tác với người dùng và quản lý
các loại nhân viên khác nhau bao gồm Android Developer, Backend Developer, Manager và ShareHolder.

## Chức năng chính

### 1. **Quản lý nhân viên**

- Thêm, sửa, xóa thông tin nhân viên
- Quản lý các loại nhân viên: Android Developer, Backend Developer, Manager, Intern, ShareHolder
- Phân cấp kỹ năng developer: Intern, Fresher, Junior, Senior (dựa trên kinh nghiệm)
- Quản lý thông tin cá nhân: tên, ngày sinh, giới tính, địa chỉ, số điện thoại, email

### 2. **Quản lý dự án**

- Tạo mới và theo dõi tiến độ dự án
- Xác định trạng thái dự án: Not Started, In Progress, Completed
- Thống kê và báo cáo tổng quan

### 3. **Hệ thống Menu Console**

- Menu tương tác qua console
- Điều hướng giữa các màn hình khác nhau
- Chức năng quay lại và thoát chương trình

### 4. **Báo cáo và thống kê**

- Báo cáo tổng quan về nhân viên và dự án
- Thống kê phân loại nhân viên theo department
- Theo dõi tiến độ dự án

## Sơ đồ các class chính trong repo

![Sơ đồ các class chính](img.png)

## Cấu trúc thư mục

```
app/src/main/java/com/eco/summaytask12/
├── data/                           # Lớp dữ liệu
│   ├── mock/                      # Dữ liệu giả lập
│   │   ├── MockEmployeeData.kt    # Mock data cho nhân viên
│   │   └── MockProjectData.kt     # Mock data cho dự án
│   ├── model/                     # Các model class
│   │   ├── androiddeveloper/      
│   │   │   └── AndroidDeveloper.kt # Class Android Developer
│   │   ├── backenddeveloper/      
│   │   │   └── BackendDeveloper.kt # Class Backend Developer
│   │   ├── dev/                   # Base developer classes
│   │   │   ├── BaseDev.kt         # Class cơ sở cho Developer
│   │   │   ├── DeveloperLevel.kt  # Enum cấp độ Developer
│   │   │   └── exercise/          # Interfaces cho exercises
│   │   ├── employee/              # Employee models
│   │   │   ├── Employee.kt        # Class cơ sở Employee
│   │   │   ├── Department.kt      # Enum phòng ban
│   │   │   └── Workable.kt        # Interface cho công việc
│   │   ├── internandroid/         
│   │   │   ├── InternAndroidDeveloper.kt # Class Intern Android Dev
│   │   │   └── DegreeType.kt      # Enum loại bằng cấp
│   │   ├── manger/                
│   │   │   └── Manager.kt         # Class Manager
│   │   ├── person/                
│   │   │   ├── Person.kt          # Class cơ sở Person
│   │   │   └── Gender.kt          # Enum giới tính
│   │   ├── project/               
│   │   │   ├── Project.kt         # Class dự án
│   │   │   └── StatusProject.kt   # Enum trạng thái dự án
│   │   └── shareholder/           
│   │       └── ShareHolder.kt     # Class cổ đông
│   ├── repository/                # Repository pattern
│   │   ├── EmployeeRepository.kt  # Repository cho nhân viên
│   │   └── ProjectRepository.kt   # Repository cho dự án
│   └── service/                   # Business logic services
│       ├── CreateEmployeeService.kt # Service tạo nhân viên
│       ├── CreateProjectService.kt  # Service tạo dự án
│       └── DataService.kt         # Service quản lý data
├── extension/                     # Extension functions
│   └── StringExt.kt              # Extensions cho String
├── menu/                         # Hệ thống menu
│   ├── screen/                   # Các màn hình
│   │   ├── AddEmployeeScreen.kt  # Màn hình thêm nhân viên
│   │   ├── EmployeeManagementScreen.kt # Quản lý nhân viên
│   │   ├── MainScreen.kt         # Màn hình chính
│   │   ├── ProjectManagementScreen.kt # Quản lý dự án
│   │   └── StaticOverviewScreen.kt # Báo cáo tổng quan
│   ├── BackStack.kt              # Quản lý navigation
│   ├── MenuAction.kt             # Actions cho menu
│   ├── MenuItem.kt               # Item của menu
│   ├── MenuResult.kt             # Result sau action
│   └── Screen.kt                 # Base screen class
├── utils/                        # Utilities
│   ├── InputHandlerUtil.kt       # Xử lý input
│   └── LoggerUtil.kt             # Logging utilities
├── MainActivity.kt               # Main Activity Android
├── Main.kt                       # Entry point cho console app
└── Const.kt                      # Constants
```

## Các kiến thức áp dụng

- **Kotlin**: Ngôn ngữ chính cho Android development
- **Lập trình hướng đối tượng (OOP)**
- **Inheritance**: Phân cấp class Person → Employee → Developer types
- **Polymorphism**: Override methods trong các subclass
- **Encapsulation**: Private/protected properties và public methods
- **Abstraction**: Abstract classes và interfaces
- **Interface Implementation**: Workable, DevExercise, JavaExercise, KotlinExercise
- **Data Classes**: Sử dụng cho Project model
- **Sealed Classes/Enums**: Department, Gender, DeveloperLevel, StatusProject
- **Extension Functions**: StringExt.kt
- **Companion Objects**: Factory methods trong Project
- **Nullable Types**: Safe null handling
- **Collections**: MutableSet, MutableList cho quản lý data
- **When Expressions**: Logic phân cấp developer level

## Mục tiêu học tập

Project co tac dụng:

- Trả lời được câu hỏi lâp trình hướng đối tượng là gì ?
- Tư duy xác được các đối tượng trong lập trình, đưa các đối tượng vào lập trình.
- Triển khai hướng đối tượng trong lâp trình.


