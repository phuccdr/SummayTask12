# SummayTask12 - Employee, Project & Device Management System

## Mô tả ngắn gọn

**SummayTask12** là một ứng dụng Android được viết bằng Kotlin, cung cấp hệ thống quản lý toàn diện
cho doanh nghiệp bao gồm quản lý nhân viên, dự án và thiết bị. Ứng dụng sử dụng giao diện console để
tương tác với người dùng và quản lý các loại nhân viên khác nhau bao gồm Android Developer, Backend
Developer, Manager và ShareHolder.

## Chức năng chính

### 1. **Quản lý nhân viên**

- Thêm, sửa, xóa thông tin nhân viên
- Quản lý các loại nhân viên: Android Developer, Backend Developer, Manager, ShareHolder
- Phân cấp kỹ năng developer: Intern, Fresher, Junior, Senior (dựa trên kinh nghiệm)
- Quản lý thông tin cá nhân: tên, ngày sinh, giới tính, địa chỉ, số điện thoại, email
- Tìm kiếm nhân viên theo tên, phòng ban

### 2. **Quản lý dự án**

- Tạo mới và theo dõi tiến độ dự án
- Xác định trạng thái dự án: Not Started, In Progress, Completed
- Cập nhật tiến độ dự án
- Thống kê và báo cáo tổng quan

### 3. **Quản lý thiết bị**

- Quản lý danh sách thiết bị công ty
- Thông tin thiết bị: tên, phiên bản OS, kích thước màn hình, RAM, bộ nhớ
- Trạng thái thiết bị: đang hoạt động/không hoạt động
- Tìm kiếm thiết bị theo tên
- Xóa thiết bị khỏi danh sách
- Thống kê chi tiết: phân loại theo OS, phân khúc, tỷ lệ hoạt động

### 4. **Hệ thống Menu Console**

- Menu tương tác qua console
- Điều hướng giữa các màn hình khác nhau với navigation stack
- Chức năng quay lại và thoát chương trình
- Xử lý input thông minh với validation

### 5. **Báo cáo và thống kê**

- Báo cáo tổng quan về nhân viên, dự án và thiết bị
- Thống kê phân loại nhân viên theo department
- Theo dõi tiến độ dự án
- Phân tích thiết bị theo phân khúc và hệ điều hành

## Sơ đồ các class chính trong repo

![Sơ đồ các class chính](img.png)

## Cấu trúc thư mục

```
app/src/main/java/com/eco/summaytask12/
├── extension/                           # Extension functions
│   └── StringExt.kt                    # Extensions cho String (normalize, gender parsing)
├── handler/                            # Input/Output handlers
│   ├── InputHandler.kt                 # Xử lý input từ user với validation
│   ├── LoggerUtil.kt                   # Logging utilities
│   └── OutputHandler.kt                # Xử lý output ra console
├── menu/                               # Hệ thống menu và navigation
│   ├── BackStack.kt                    # Quản lý navigation stack
│   └── screen/                         # Các màn hình
│       ├── addemployee/                
│       │   └── AddEmployeeScreen.kt    # Màn hình thêm nhân viên
│       ├── devicemanagement/           
│       │   └── DeviceManagementScreen.kt # Màn hình quản lý thiết bị
│       ├── employeemanagement/         
│       │   └── EmployeeManagementScreen.kt # Màn hình quản lý nhân viên
│       ├── main/                       
│       │   └── MainScreen.kt           # Màn hình chính
│       ├── projectmanagement/          
│       │   └── ProjectManagementScreen.kt # Màn hình quản lý dự án
│       └── statisticoverview/          
│           └── StatisticsOverviewScreen.kt # Màn hình báo cáo thống kê
├── model/                              # Các model class
│   ├── androiddeveloper/               
│   │   └── AndroidDeveloper.kt         # Class Android Developer
│   ├── backenddeveloper/               
│   │   └── BackendDeveloper.kt         # Class Backend Developer
│   ├── dev/                            # Base developer classes
│   │   ├── BaseDev.kt                  # Class cơ sở cho Developer
│   │   ├── DeveloperLevel.kt           # Enum cấp độ Developer
│   │   └── exercise/                   # Interfaces cho exercises
│   │       ├── DevExercise.kt          # Base exercise interface
│   │       ├── JavaExercise.kt         # Java exercise interface
│   │       └── KotlinExercise.kt       # Kotlin exercise interface
│   ├── device/                         # Device model
│   │   └── Device.kt                   # Class thiết bị (data class)
│   ├── employee/                       # Employee models
│   │   ├── Employee.kt                 # Class cơ sở Employee
│   │   ├── Department.kt               # Enum phòng ban (Product/Outsource)
│   │   └── Workable.kt                 # Interface cho công việc
│   ├── manger/                         
│   │   └── Manager.kt                  # Class Manager
│   ├── menuitem/                       
│   │   └── MenuItem.kt                 # Class menu item với onClick
│   ├── person/                         
│   │   ├── Person.kt                   # Class cơ sở Person
│   │   └── Gender.kt                   # Enum giới tính
│   ├── project/                        
│   │   ├── Project.kt                  # Class dự án (data class)
│   │   └── StatusProject.kt            # Enum trạng thái dự án
│   ├── screen/                         
│   │   └── Screen.kt                   # Base screen class với navigation
│   └── shareholder/                    
│       └── ShareHolder.kt              # Class cổ đông
├── repository/                         # Repository pattern
│   ├── datastorage/                    # Mock data storage
│   │   ├── MockDeviceData.kt           # Mock data cho thiết bị
│   │   ├── MockEmployeeData.kt         # Mock data cho nhân viên
│   │   └── MockProjectData.kt          # Mock data cho dự án
│   ├── DeviceRepository.kt             # Repository cho thiết bị
│   ├── EmployeeRepository.kt           # Repository cho nhân viên
│   └── ProjectRepository.kt            # Repository cho dự án
├── services/                           # Business logic services
│   └── DataService.kt                  # Service quản lý data tổng hợp
├── utils/                              # Utilities
│   ├── Constant.kt                     # Constants và messages
│   ├── CreateEmployeeUtil.kt           # Utility tạo nhân viên
│   └── CreateProjectUtil.kt            # Utility tạo dự án
├── MainActivity.kt                     # Main Activity Android
├── Main.kt                             # Entry point cho console app
└── test.kt                             # File test
```

## Các kiến thức áp dụng

## Kiến thức áp dụng trong Kotlin

### 1. Cú pháp cơ bản

- **Biến & Hằng số**
- **Kiểu dữ liệu**: `Int`, `Float`, `Boolean`, `String`, `Char`, `Double`, `Long`
- **Toán tử**: `+`, `-`, `*`, `/`, `%`, `+=`, `-=`, `==`, `!=`, `>`, `<`, `&&`, `||`
- **Ép kiểu**: `toInt()`, `toString()`, `toDouble()`, ...
- **Chuỗi & String Template**: `"Hello, $name"`

### 2. Cấu trúc điều kiện & vòng lặp

- `if - else`
- `when` (tương tự `switch-case` trong Java)
- `for (i in 1..10) { }`
- `while` & `do-while`

### 3. Collection (Danh sách dữ liệu)

- `List` (Danh sách)
- `Set` (Tập hợp không trùng lặp)
- `Map` (Dạng key-value)
- Một số hàm quan trọng:
    - `map()`, `filter()`, `reduce()`
    - `forEach()`, `first()`, `last()`

### 4. Hàm & Extension Function

- Hàm thông thường
- Hàm một dòng
- **Default Parameter** & **Named Argument**
- **Extension Function**

### 5. Null Safety

- **Nullable (?)** và **Non-nullable**
- **Elvis Operator (`?:`)**
- **Safe Call (`?.`)**
- **Not-null Assertion (`!!`)**

### 6. Lập trình hướng đối tượng (OOP)

- **Class & Object**
- **Constructor** (Primary & Secondary)
- **Kế thừa** (`open class`, `override`)
- **Interface & Abstract Class**
- **Data Class**
- **Singleton & Companion Object**

## Application:

### Lập trình hướng đối tượng (OOP)

- **Inheritance**: Phân cấp class Person → Employee → Developer types
- **Polymorphism**: Override methods trong các subclass
- **Encapsulation**: Private/protected properties và public methods
- **Abstraction**: Abstract classes và interfaces

### Kotlin Features

- **Data Classes**: Sử dụng cho Project, Device models
- **Sealed Classes/Enums**: Department, Gender, DeveloperLevel, StatusProject
- **Extension Functions**: StringExt.kt (normalizeUserName, toGender)
- **Companion Objects**: Factory methods và shared instances
- **Nullable Types**: Safe null handling với ?.let, ?: operators
- **Lambda Functions**: onClick callbacks cho MenuItem
- **Higher-Order Functions**: filter, map, forEach trong repositories

### Collections & Data Structures

- **MutableList**: Quản lý danh sách dynamic
- **MutableSet**: Đảm bảo không trùng lặp
- **Map**: Thống kê và key-value data
- **Filter & Search**: Lambda expressions cho tìm kiếm

### Error Handling

- **Exception Handling**: Try-catch blocks
- **Input Validation**: Kiểm tra input trong InputHandler
- **Null Safety**: Kotlin null-safe operators

## Mục tiêu học tập

Project có tác dụng:

- Trả lời được câu hỏi lập trình hướng đối tượng là gì?
- Tư duy xác định được các đối tượng trong lập trình, đưa các đối tượng vào lập trình
- Triển khai hướng đối tượng trong lập trình
- Làm việc với collections và data structures trong Kotlin

## Hướng dẫn chạy ứng dụng

1. Clone repository
2. Mở project bằng Android Studio
3. Chạy file `Main.kt` để khởi động console application
4. Hoặc build và chạy trên Android device/emulator

