# 📌 KẾ HOẠCH PHÁT TRIỂN DỰ ÁN WEB BÁN ĐỒNG HỒ

## 🔗 **Tài liệu chi tiết**
[📄 Xem tài liệu trên Google Docs](https://docs.google.com/document/d/1yl-JSgz586TgAU-3HmlkMcfWUaWcp2-sJ9SMAVK1DnM/edit?tab=t.0)

## 🔗 **Kế hoạch thực hiện chi tiết**
[📄 Xem tài liệu trên Google Sheets](https://docs.google.com/spreadsheets/d/1Kw4UIclchXwuC_yKuIWTfFBJPIG97-qdbnDHOvwNq3M/edit?gid=0#gid=0)

## 📌 GIỚI THIỆU
Dự án xây dựng một hệ thống bán đồng hồ trực tuyến theo kiến trúc **Microservice** sử dụng **Spring Boot**. Hệ thống bao gồm các dịch vụ như **quản lý tài khoản, sản phẩm, đơn hàng, giỏ hàng, xác thực và nhận hàng**.

## 🚀 CÔNG NGHỆ SỬ DỤNG
- **Backend:** Spring Boot, Spring Cloud, Spring Security, JPA, Hibernate
- **Frontend:** ReactJS / Angular *(tùy chọn)*
- **Cơ sở dữ liệu:** MySQL / PostgreSQL
- **Triển khai:** Docker, Kubernetes *(nếu có thời gian)*
- **Công cụ hỗ trợ:** GitHub, Postman, Swagger, Eureka, API Gateway

## 📅 KẾ HOẠCH THỰC HIỆN

## 📆 Giai đoạn | 📌 Công việc | 👥 Thành viên phụ trách

✅ **Tuần 1**
- 📌 Tìm hiểu về Spring Boot (Monolithic + Microservice) và các công nghệ liên quan  
- 👥 **Cả nhóm**

✅ **Tuần 2**
- 📌 Xây dựng cơ sở dữ liệu *(Ánh)*  
- 📌 Thiết kế ERD *(Tùng)*  
- 📌 Thiết kế giao diện frontend *(Hiếu)*  

✅ **Tuần 3**
- 📌 Xây dựng API theo kiến trúc Monolithic  
- 📌 Deploy dự án lên Docker  
- 👥 **Cả nhóm**

✅ **Tuần 4**
- 📌 Tìm hiểu sâu hơn về kiến trúc Microservice  
- 📌 Thiết kế mô hình Microservice sử dụng trong dự án  
- 👥 **Cả nhóm**

✅ **Tuần 5**
📌 Xây dựng các service:
  - **account-service** *(Hiếu)*
  - **product-service** *(Ánh)*
  - **order-service** *(Tùng)*

✅ **Tuần 6**
📌 Xây dựng các service:
  - **auth-service** *(Hiếu)*
  - **cart-service** *(Ánh)*
  - **received-service** *(Tùng)*

✅ **Tuần 7**
- 📌 Cấu hình **Config-Service** để quản lý cấu hình tập trung  
- 📌 Cấu hình **Discovery-Service** với Eureka để quản lý và tìm kiếm service  
- 📌 Cấu hình **API Gateway** để làm cổng giao tiếp giữa client và các service  
- 👥 **Cả nhóm**

✅ **Tuần 8**
- 📌 Triển khai Docker  
- 📌 Viết tài liệu báo cáo  
- 👥 **Cả nhóm**

✅ **Tuần 9**
- 📌 Chuẩn bị báo cáo cuối kỳ, slide thuyết trình  
- 👥 **Cả nhóm**