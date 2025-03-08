# Watch Shop - Monolithic Application

## 🛠️ Yêu cầu hệ thống

- **JDK 23** (hoặc phiên bản tương thích)
- **Maven 3.8+**
- **MySQL 8.0+**
- **Git** (để clone project)

## 📥 Clone project

Mở terminal và chạy lệnh:
```sh
git clone https://github.com/trantronghieu222/CNLTHD_Project.git
cd CNLTHD_Project/Monolithic/watch-shop
```

## 🔧 Cấu hình database

1. Mở MySQL và tạo database:
```sql
CREATE DATABASE db_clockshop;
```

## 🚀 Chạy ứng dụng

### 1. Chạy bằng Maven
```sh
mvn spring-boot:run
```
### 2. Chạy với docker
```sh
mvn clean package
docker-compose up -d --build
```

## 📝 API Documentation

Sau khi chạy thành công, bạn có thể truy cập tài liệu API tại:
- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## 🛠️ Các lệnh hữu ích

### Build project
```sh
mvn clean package
```

### Chạy test
```sh
mvn test
```

### Kiểm tra lỗi code với Checkstyle
```sh
mvn checkstyle:check
```

## 🔗 Liên hệ & Đóng góp
- Nếu gặp lỗi, hãy mở issue trên GitHub.
- Đóng góp bằng cách tạo pull request.

---
📌 **Chúc bạn cài đặt và chạy ứng dụng thành công!** 🚀