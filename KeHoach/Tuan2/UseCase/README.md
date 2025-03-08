## 2.2. Biểu đồ Usecase trong hệ thống

### 2.2.1. Usecase tổng quát

![Usecase tổng quát](../UCtongquat.jpg)

### 2.2.2. Đặc tả Use Case

#### Use Case 1: Đăng ký
- **Mô tả:** Người dùng có thể tạo tài khoản mới để sử dụng hệ thống.
- **Tác nhân:** User
- **Luồng sự kiện chính:**
  1. Người dùng chọn chức năng "Đăng ký".
  2. Hệ thống hiển thị form đăng ký.
  3. Người dùng nhập thông tin (tên, email, mật khẩu, v.v.).
  4. Hệ thống kiểm tra tính hợp lệ của thông tin.
  5. Hệ thống lưu thông tin người dùng vào cơ sở dữ liệu.
  6. Hệ thống hiển thị thông báo đăng ký thành công.

#### Use Case 2: Đăng nhập
- **Mô tả:** Người dùng có thể đăng nhập vào hệ thống để sử dụng các chức năng.
- **Tác nhân:** User, Admin, Employee
- **Luồng sự kiện chính:**
  1. Người dùng nhập tên đăng nhập và mật khẩu.
  2. Hệ thống xác thực thông tin.
  3. Nếu thông tin hợp lệ, hệ thống cho phép truy cập.
  4. Nếu thông tin không hợp lệ, hệ thống báo lỗi.

#### Use Case 3: Tìm kiếm sản phẩm
- **Mô tả:** Người dùng có thể tìm kiếm sản phẩm theo từ khóa.
- **Tác nhân:** User
- **Luồng sự kiện chính:**
  1. Người dùng nhập từ khóa tìm kiếm.
  2. Hệ thống hiển thị danh sách sản phẩm phù hợp.

#### Use Case 4: Xem sản phẩm
- **Mô tả:** Người dùng có thể xem danh sách sản phẩm.
- **Tác nhân:** User
- **Luồng sự kiện chính:**
  1. Người dùng chọn chức năng "Xem sản phẩm".
  2. Hệ thống hiển thị danh sách sản phẩm.

#### Use Case 5: Xem chi tiết sản phẩm
- **Mô tả:** Người dùng có thể xem thông tin chi tiết của một sản phẩm cụ thể.
- **Tác nhân:** User
- **Luồng sự kiện chính:**
  1. Người dùng chọn một sản phẩm từ danh sách.
  2. Hệ thống hiển thị chi tiết sản phẩm.

#### Use Case 6: Quản lý giỏ hàng
- **Mô tả:** Người dùng có thể thêm, xóa hoặc sửa đổi sản phẩm trong giỏ hàng.
- **Tác nhân:** User
- **Luồng sự kiện chính:**
  1. Người dùng chọn sản phẩm để thêm vào giỏ hàng.
  2. Hệ thống cập nhật giỏ hàng.
  3. Người dùng có thể xóa hoặc chỉnh sửa sản phẩm trong giỏ hàng.

#### Use Case 7: Đặt hàng
- **Mô tả:** Người dùng có thể đặt hàng sau khi đã chọn sản phẩm vào giỏ hàng.
- **Tác nhân:** User
- **Luồng sự kiện chính:**
  1. Người dùng chọn chức năng "Đặt hàng".
  2. Hệ thống xác nhận thông tin đơn hàng.
  3. Hệ thống lưu đơn hàng và thông báo thành công.

#### Use Case 8: Quản lý sản phẩm
- **Mô tả:** Admin có thể thêm, sửa, xóa sản phẩm trong hệ thống.
- **Tác nhân:** Admin
- **Luồng sự kiện chính:**
  1. Admin chọn chức năng quản lý sản phẩm.
  2. Admin có thể thêm, sửa, xóa sản phẩm.
  3. Hệ thống cập nhật thông tin sản phẩm.

#### Use Case 9: Quản lý người dùng
- **Mô tả:** Admin có thể quản lý danh sách người dùng, bao gồm thêm, xóa hoặc chỉnh sửa thông tin.
- **Tác nhân:** Admin
- **Luồng sự kiện chính:**
  1. Admin chọn chức năng quản lý người dùng.
  2. Admin thêm, sửa hoặc xóa người dùng.
  3. Hệ thống cập nhật dữ liệu.

#### Use Case 10: Quản lý đơn hàng
- **Mô tả:** Admin có thể xem và xử lý đơn hàng của khách hàng.
- **Tác nhân:** Admin
- **Luồng sự kiện chính:**
  1. Admin chọn chức năng quản lý đơn hàng.
  2. Hệ thống hiển thị danh sách đơn hàng.
  3. Admin có thể xác nhận hoặc hủy đơn hàng.
  4. Hệ thống cập nhật trạng thái đơn hàng thành công.

#### Use Case 11: Nhập hàng
- **Mô tả:** Nhân viên có thể nhập hàng vào hệ thống.
- **Tác nhân:** Employee
- **Luồng sự kiện chính:**
  1. Nhân viên chọn chức năng nhập hàng.
  2. Nhân viên nhập thông tin sản phẩm mới.
  3. Hệ thống cập nhật dữ liệu hàng tồn kho.