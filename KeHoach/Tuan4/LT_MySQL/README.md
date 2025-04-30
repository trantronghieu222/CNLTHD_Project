# Cơ sở dữ liệu

## 1. Tìm hiểu về MySQL

### Tổng quan về hệ quản trị cơ sở dữ liệu MySQL

MySQL là một hệ quản trị cơ sở dữ liệu quan hệ (Relational Database Management System – RDBMS) mã nguồn mở, được sử dụng rộng rãi trong phát triển phần mềm web. MySQL sử dụng ngôn ngữ truy vấn SQL (Structured Query Language) để thực hiện các thao tác như truy vấn, thêm, sửa, xóa và quản lý dữ liệu. 

Với khả năng xử lý dữ liệu hiệu quả, tính ổn định cao, và dễ dàng tích hợp với nhiều nền tảng khác nhau như PHP, Java (Spring Boot), MySQL đã trở thành một trong những lựa chọn hàng đầu cho các hệ thống quản lý thông tin, đặc biệt trong các mô hình ứng dụng thương mại điện tử hoặc quản lý bán hàng.

### Ưu điểm của MySQL
- **Mã nguồn mở và miễn phí**: Người dùng có thể sử dụng, chỉnh sửa và phân phối MySQL mà không mất chi phí bản quyền.
- **Hiệu năng cao**: MySQL xử lý tốt các truy vấn trên hệ thống vừa và lớn, với tốc độ phản hồi nhanh.
- **Dễ tích hợp**: Tương thích tốt với các framework backend như Spring Boot, Laravel, Django.
- **Hỗ trợ chuẩn SQL**: Cho phép sử dụng các tính năng chuẩn như khóa chính, khóa ngoại, chỉ mục, trigger, view, v.v.
- **Tính bảo mật cao**: Cung cấp khả năng quản lý người dùng, phân quyền truy cập, mã hóa kết nối SSL.
- **Cộng đồng phát triển lớn**: Có nhiều tài liệu, diễn đàn hỗ trợ, giúp việc triển khai và xử lý lỗi trở nên thuận tiện.

### Nhược điểm của MySQL
- **Hạn chế trong xử lý dữ liệu phi cấu trúc**: MySQL không phù hợp với các hệ thống cần lưu trữ dữ liệu NoSQL hoặc dạng JSON lớn, phức tạp.
- **Tính năng nâng cao giới hạn ở bản Community**: Một số tính năng như sao lưu nâng cao, cân bằng tải,... chỉ có ở phiên bản thương mại (Enterprise).
- **Không tối ưu cho Big Data/Realtime Analytics**: Các ứng dụng phân tích dữ liệu lớn thường cần kết hợp với các hệ thống như Hadoop hoặc sử dụng CSDL chuyên biệt như MongoDB, Elasticsearch.

### Ứng dụng của MySQL trong hệ thống Watch Shop
Trong đề tài này, MySQL được lựa chọn làm hệ quản trị cơ sở dữ liệu chính nhằm lưu trữ toàn bộ thông tin liên quan đến hệ thống bán hàng Watch Shop, bao gồm:
- **Thông tin tài khoản người dùng**: email, mật khẩu, phân quyền (admin, khách hàng).
- **Danh mục sản phẩm và chi tiết sản phẩm**: tên, giá, mô tả, số lượng tồn kho, hình ảnh, hãng sản xuất,...
- **Đơn đặt hàng và chi tiết đơn hàng**: thời gian đặt, tổng tiền, trạng thái giao hàng,...
- **Đơn nhập hàng và nhà cung cấp**: hỗ trợ quản lý kho và chuỗi cung ứng.
- **Hành vi người dùng**: giỏ hàng, lịch sử đặt hàng, cập nhật thông tin cá nhân.

Hệ thống backend sử dụng Spring Boot kết nối đến MySQL thông qua Spring Data JPA, sử dụng Hibernate ORM để ánh xạ dữ liệu từ bảng (table) sang đối tượng Java (entity). Điều này giúp tách biệt rõ ràng giữa tầng xử lý nghiệp vụ và tầng lưu trữ, tăng khả năng bảo trì và mở rộng hệ thống về sau.

## 2. Cài đặt MySQL

Việc cài đặt MySQL có thể thực hiện theo nhiều cách tùy thuộc vào hệ điều hành và môi trường phát triển:
- **Sử dụng trình quản lý gói**: Trên các hệ điều hành Linux (như Ubuntu, CentOS), có thể sử dụng các lệnh như `apt-get install mysql-server` hoặc `yum install mysql-community-server`.
- **Sử dụng trình cài đặt chính thức**: Oracle cung cấp các trình cài đặt (Installer) cho Windows và macOS trên trang chủ MySQL, giúp quá trình cài đặt và cấu hình ban đầu (như đặt mật khẩu root, cấu hình dịch vụ) trở nên trực quan hơn.
- **Sử dụng Docker**: Một phương pháp phổ biến hiện nay, đặc biệt trong môi trường phát triển và microservice, là chạy MySQL dưới dạng một container Docker. Điều này giúp cô lập môi trường CSDL, dễ dàng khởi tạo và quản lý các phiên bản khác nhau. Lệnh cơ bản:
  ```bash
  docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:latest
  ```

# 3. Truy cập và thao tác dữ liệu

## Kết nối cơ sở dữ liệu trong Spring Boot

Như đã đề cập ở phần 2.2.4, Spring Boot đơn giản hóa việc kết nối đến cơ sở dữ liệu thông qua cấu hình trong file `application.properties` hoặc `application.yml`. Các thuộc tính chính cần khai báo bao gồm:

- `spring.datasource.url`: Chuỗi kết nối JDBC đến cơ sở dữ liệu (ví dụ: `jdbc:mysql://<host>:<port>/<database_name>`).
- `spring.datasource.username`: Tên người dùng để kết nối.
- `spring.datasource.password`: Mật khẩu của người dùng.
- `spring.datasource.driver-class-name`: (Tùy chọn, thường Spring Boot tự phát hiện) Tên lớp Driver JDBC (ví dụ: `com.mysql.cj.jdbc.Driver` cho MySQL 8+).

Spring Boot mặc định sử dụng HikariCP làm thư viện quản lý connection pool, giúp tối ưu hóa hiệu suất và quản lý tài nguyên kết nối đến cơ sở dữ liệu một cách hiệu quả. Các tham số của connection pool cũng có thể được tùy chỉnh trong file cấu hình nếu cần.

## Viết các truy vấn, thao tác CRUD cơ bản

### Tạo mới (Create)

```java
@PostMapping("/products")
public Product createProduct(@RequestBody Product product) {
  return productRepository.save(product);
}
```
### Đọc dữ liệu (Read)

```java
@GetMapping("/products")
public List<Product> getAllProducts() {
    return productRepository.findAll();
}
```
### Cập nhật (Update)
```java
@PutMapping("/products/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
  Product product = productRepository.findById(id).orElseThrow();
  product.setPrice(newProduct.getPrice());
  return ResponseEntity.ok(productRepository.save(product));
}
```

### Xóa (Delete)
```java
@DeleteMapping("/products/{id}")
public void deleteProduct(@PathVariable Long id) {
  productRepository.deleteById(id);
}
```

# 4. ORM (Object-Relational Mapping)
ORM (Object-Relational Mapping) là một kỹ thuật lập trình cho phép chuyển đổi dữ liệu giữa hệ thống cơ sở dữ liệu quan hệ (như MySQL) và các đối tượng trong ngôn ngữ lập trình hướng đối tượng (như Java). Mục tiêu chính của ORM là giúp lập trình viên làm việc với cơ sở dữ liệu thông qua các đối tượng Java quen thuộc thay vì phải viết và quản lý trực tiếp các câu lệnh SQL.

### Cách hoạt động và lợi ích

- **Ánh xạ (Mapping):** ORM thực hiện ánh xạ giữa các lớp (Class) trong Java với các bảng (Table) trong cơ sở dữ liệu, các thuộc tính (Field) của lớp với các cột (Column) trong bảng, và các mối quan hệ giữa các lớp (như One-to-One, One-to-Many, Many-to-Many) với các khóa ngoại (Foreign Key) và bảng trung gian.

- **Trừu tượng hóa truy vấn:** ORM cung cấp API để thực hiện các thao tác CRUD và các truy vấn phức tạp hơn thông qua các phương thức hướng đối tượng, thay vì phải viết SQL.

- **Độc lập cơ sở dữ liệu:** ORM giúp giảm sự phụ thuộc vào một loại CSDL cụ thể, cho phép ứng dụng có thể chuyển sang sử dụng một CSDL quan hệ khác mà không cần sửa đổi nhiều mã nguồn liên quan đến truy vấn dữ liệu.

- **Tự động hóa:** ORM tự động quản lý các phiên làm việc (session), giao dịch (transaction), và cơ chế caching, giúp giảm thiểu mã lệnh lặp đi lặp lại (boilerplate code).

### JPA và Hibernate

- **JPA (Java Persistence API):** Là một đặc tả chuẩn của Java EE (nay là Jakarta EE) định nghĩa cách thức thực hiện ORM trong Java. Nó cung cấp một tập hợp các interface và annotation chuẩn.

- **Hibernate:** Là một trong những framework ORM phổ biến và mạnh mẽ nhất, hiện thực hóa đặc tả JPA. Spring Boot khi sử dụng spring-boot-starter-data-jpa mặc định sẽ tích hợp Hibernate làm implementation cho JPA.

Trong dự án này, việc sử dụng Spring Data JPA (với Hibernate bên dưới) giúp đơn giản hóa đáng kể tầng truy cập dữ liệu (Repository Layer), cho phép tập trung vào logic nghiệp vụ thay vì xử lý các chi tiết phức tạp của JDBC và SQL.

# Triển khai và CI/CD
## 1. Triển khai ứng dụng với Docker
Docker là một nền tảng container hóa hàng đầu, cho phép đóng gói ứng dụng và các phụ thuộc của nó vào một đơn vị độc lập, nhẹ và có thể chạy được gọi là container. Container đảm bảo ứng dụng hoạt động nhất quán trên mọi môi trường, từ máy tính cá nhân của lập trình viên đến môi trường production.

## Lợi ích của Docker trong dự án Microservice

- **Đóng gói độc lập:** Mỗi microservice (ví dụ: auth-service, product-service) có thể được đóng gói thành một Docker image riêng biệt cùng với môi trường chạy Java (JDK/JRE) và các thư viện cần thiết.
  
- **Triển khai nhất quán:** Image Docker đảm bảo microservice chạy giống hệt nhau trên môi trường local, testing, staging và production.

- **Cô lập môi trường:** Các container chạy độc lập, tránh xung đột về thư viện hoặc cổng giữa các microservice.

- **Khả năng mở rộng dễ dàng:** Có thể dễ dàng khởi chạy nhiều instance (container) của một microservice để đáp ứng tải tăng cao.

- **Quản lý đơn giản:** Các công cụ như Docker Compose cho phép định nghĩa và chạy một ứng dụng đa container (toàn bộ hệ thống microservice) bằng một file cấu hình duy nhất (`docker-compose.yml`), rất hữu ích cho môi trường phát triển và kiểm thử cục bộ.

## Quy trình cơ bản

### Viết Dockerfile

Tạo một file tên là `Dockerfile` trong thư mục gốc của mỗi dự án microservice Spring Boot. File này chứa các chỉ dẫn để xây dựng image.

**Ví dụ Dockerfile:**

```dockerfile
# Sử dụng base image OpenJDK 17
FROM openjdk:17-jdk-slim

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Copy file JAR đã build vào thư mục làm việc trong container
# Giả sử file JAR nằm trong thư mục target và có tên là app.jar
COPY target/*.jar app.jar

# Khai báo cổng mà ứng dụng sẽ lắng nghe
EXPOSE 8080

# Lệnh để chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Build Image:
Sử dụng lệnh sau để tạo Docker image từ Dockerfile:

```bash
docker build -t <image_name>:<tag> .
```

### Run Container::
Sử dụng lệnh docker run -p <host_port>:<container_port> <image_name>:<tag> để khởi chạy một container từ image đã build.

Trong dự án này, việc sử dụng Docker giúp đơn giản hóa việc thiết lập môi trường chạy cho từng microservice và cơ sở dữ liệu (MySQL cũng có thể chạy trong Docker container), đồng thời là nền tảng cho việc triển khai lên các môi trường cloud hoặc dàn dựng (orchestration) phức tạp hơn như Kubernetes.

## 2. CI/CD trong quá trình triển khai
CI/CD là viết tắt của **Continuous Integration** (Tích hợp liên tục) và **Continuous Delivery/Deployment** (Giao hàng/Triển khai liên tục). Đây là một tập hợp các thực hành và quy trình tự động hóa nhằm mục đích tăng tốc độ và độ tin cậy trong việc đưa các thay đổi phần mềm đến tay người dùng.

### Continuous Integration (CI)

- **Mục tiêu**: Tự động hóa việc hợp nhất mã nguồn từ nhiều lập trình viên vào một kho lưu trữ chung, sau đó tự động build và chạy các bài kiểm thử (unit test, integration test) mỗi khi có thay đổi mới (thường là mỗi commit).
- **Lợi ích**: Phát hiện sớm lỗi tích hợp, đảm bảo mã nguồn luôn ở trạng thái hoạt động tốt, giảm thiểu xung đột mã nguồn.
- **Công cụ phổ biến**: Jenkins, GitLab CI/CD, GitHub Actions, CircleCI.

### Continuous Delivery (CD)

- **Mục tiêu**: Tự động hóa quá trình chuẩn bị phiên bản phần mềm (build, test, đóng gói - ví dụ: tạo Docker image) để sẵn sàng triển khai ra môi trường production bất cứ lúc nào. Việc triển khai cuối cùng ra production thường vẫn cần một bước phê duyệt thủ công.
- **Lợi ích**: Giảm thiểu rủi ro trong quá trình release, đảm bảo mọi phiên bản sẵn sàng triển khai đều đã được kiểm thử kỹ lưỡng.

### Continuous Deployment (CD - dạng nâng cao)

- **Mục tiêu**: Tự động hóa toàn bộ quy trình từ CI đến triển khai ra môi trường production mà không cần sự can thiệp thủ công, miễn là phiên bản đó vượt qua tất cả các bài kiểm thử tự động.
- **Lợi ích**: Tốc độ đưa tính năng mới đến người dùng nhanh nhất có thể.

---

### Quy trình CI/CD điển hình cho Microservice:

1. **Lập trình viên đẩy (push)** mã nguồn lên Git repository (ví dụ: GitHub, GitLab).
2. **Hệ thống CI tự động kích hoạt (trigger).**

3. CI Pipeline:

- Checkout mã nguồn mới nhất.
- Biên dịch mã nguồn (ví dụ: `mvn package` để tạo file JAR).
- Chạy unit tests.
- Chạy integration tests (có thể cần khởi tạo các dependency như DB trong môi trường test).
- *(Tùy chọn)* Phân tích chất lượng mã nguồn (SonarQube).
- Đóng gói ứng dụng (ví dụ: Build Docker image).
- Đẩy (push) Docker image lên một registry (ví dụ: Docker Hub, GitLab Container Registry).

4. CD Pipeline:

- Triển khai image mới lên môi trường Staging/Testing.
- Chạy end-to-end tests hoặc thực hiện kiểm thử thủ công trên môi trường Staging.
- **(Continuous Delivery)**: Chờ phê duyệt để triển khai lên Production.
- **(Continuous Deployment)**: Tự động triển khai lên Production nếu tất cả các bước trước thành công.

---

## Ứng dụng trong dự án

Đối với dự án này, việc áp dụng CI/CD (dù ở mức độ cơ bản) sẽ giúp **tự động hóa quá trình kiểm thử và đóng gói các microservice** mỗi khi có thay đổi, **đảm bảo chất lượng và giảm thiểu công sức thủ công**, đặc biệt quan trọng khi số lượng microservice tăng lên.