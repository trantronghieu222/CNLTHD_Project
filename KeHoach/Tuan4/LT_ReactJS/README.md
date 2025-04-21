# 🛍️ Watch Shop - Giao Diện Người Dùng với ReactJS

Dự án Watch Shop là hệ thống bán hàng đồng hồ trực tuyến với giao diện người dùng hiện đại, được xây dựng bằng thư viện ReactJS. Ứng dụng hướng đến trải nghiệm mua sắm mượt mà, dễ sử dụng và tương thích với nhiều thiết bị.

---

## 📌 Mục lục

- [🔍 1. Giới thiệu ReactJS](#-1-giới-thiệu-reactjs)
- [🎨 2. Thiết kế giao diện người dùng](#-2-thiết-kế-giao-diện-người-dùng)
- [⚙️ 3. Xử lý tương tác người dùng](#️-3-xử-lý-tương-tác-người-dùng)
- [✅ 4. Kết luận](#-4-kết-luận)

---

## 🔍 1. Giới thiệu ReactJS

**ReactJS** là một thư viện JavaScript mã nguồn mở do Facebook phát triển, hỗ trợ xây dựng UI cho các ứng dụng web có tính tương tác cao.

### 🌟 Đặc điểm nổi bật:
- **Component-based**: UI chia thành các thành phần nhỏ, tái sử dụng hiệu quả.
- **Virtual DOM**: Cập nhật giao diện tối ưu, chỉ thay đổi thành phần bị ảnh hưởng.
- **One-way data binding**: Dữ liệu truyền một chiều từ component cha xuống con.
- **JSX (JavaScript XML)**: Viết HTML trong JavaScript, tăng tính trực quan.
- **Hiệu năng cao**: Kết hợp Virtual DOM và cơ chế reconciliation tối ưu hiệu suất.

### ✅ Lợi ích khi sử dụng React:
- Tăng tốc phát triển nhờ chia nhỏ giao diện.
- Dễ bảo trì, dễ mở rộng do tính module hoá.
- Cộng đồng lớn, tài liệu phong phú, nhiều thư viện hỗ trợ như React Router, Redux, MUI,...
- Tích hợp dễ dàng với backend REST API hoặc GraphQL.
- Có thể mở rộng thành mobile app (React Native) hoặc SSR (Next.js).

---

## 🎨 2. Thiết kế giao diện người dùng

### 🧰 Công cụ sử dụng:
- **Balsamiq Mockups**: Dùng để phác thảo wireframe các màn hình nhanh chóng, trực quan.
- **Responsive Design**: Thiết kế tương thích nhiều thiết bị từ desktop đến mobile.

### 🔗 Kết nối chặt chẽ với backend:
- Mỗi màn hình được thiết kế kèm API tương ứng.
- Đảm bảo frontend và backend phát triển đồng bộ, giảm lỗi khi tích hợp.

### 🖼️ Các giao diện chính bao gồm:

#### 1. Trang chủ (Home page)
- Hiển thị sản phẩm nổi bật, banner khuyến mãi, danh mục nổi bật.
- Liên kết nhanh đến các trang chức năng khác.

#### 2. Trang danh sách sản phẩm
- Lọc sản phẩm theo hãng, mức giá,...
- Cho phép sắp xếp và tìm kiếm nhanh.

#### 3. Trang chi tiết sản phẩm
- Hiển thị hình ảnh lớn, mô tả chi tiết, đánh giá, nút thêm vào giỏ hàng.

#### 4. Trang giỏ hàng
- Danh sách sản phẩm đã chọn.
- Cho phép cập nhật số lượng, xoá sản phẩm, chuyển sang bước thanh toán.

#### 5. Trang lịch sử đặt hàng
- Hiển thị danh sách các đơn đã đặt.
- Thông tin đơn hàng gồm mã đơn, ngày, tổng tiền, trạng thái giao hàng.

#### 6. Trang hồ sơ người dùng (Profile)
- Người dùng xem, cập nhật thông tin cá nhân: họ tên, email, số điện thoại, địa chỉ giao hàng mặc định,...

#### 7. Trang đăng nhập / đăng ký
- Tạo tài khoản và đăng nhập để đặt hàng, xem lịch sử giao dịch.

#### 8. Trang quản lý admin
- Quản lý sản phẩm, đơn hàng, người dùng.
- Thống kê doanh thu theo thời gian, đơn hàng, trạng thái giao hàng.

---

## ⚙️ 3. Xử lý tương tác người dùng

Trong ReactJS, tương tác người dùng được xử lý hiệu quả và phản hồi tức thì nhờ các công cụ quản lý sự kiện, trạng thái, và gọi API.

### 🖱️ 3.1 Quản lý sự kiện (Event Handling)

React hỗ trợ xử lý sự kiện giống với JavaScript truyền thống, nhưng sử dụng cú pháp camelCase và hoạt động theo mô hình ảo hóa DOM (Virtual DOM). Các sự kiện phổ biến như `onClick`, `onChange`, `onSubmit`, `onMouseEnter`,... được gắn trực tiếp vào JSX.

Trong hệ thống Watch Shop, các sự kiện được sử dụng cho:

- Nhấn nút “Mua ngay” để thêm sản phẩm vào giỏ hàng.
- Chọn filter sắp xếp theo giá hoặc thương hiệu.
- Thay đổi số lượng trong giỏ hàng.
- Gửi biểu mẫu đăng ký/đăng nhập.

### ⚡ 3.2 Quản lý trạng thái giao diện (State Management)

React sử dụng `useState` để quản lý trạng thái cục bộ trong component. Ví dụ, khi người dùng nhấn nút tăng số lượng sản phẩm, React sẽ cập nhật lại giao diện tức thì mà không cần reload trang:

```jsx
const [quantity, setQuantity] = useState(1);
const increase = () => setQuantity(quantity + 1);
```

Các trạng thái được quản lý bao gồm:
- **Trạng thái giỏ hàng**: Số lượng sản phẩm và tổng tiền sẽ được cập nhật khi người dùng thêm hoặc xóa sản phẩm khỏi giỏ hàng.
- **Trạng thái hiển thị modal**: Quản lý trạng thái mở/đóng các modal như form đăng nhập, xem chi tiết đơn hàng, hay cập nhật thông tin.
- **Loading, thông báo**: Quản lý trạng thái hiển thị loading spinner khi dữ liệu đang được tải và hiển thị thông báo (toast, snackbar) khi có các sự kiện như "Thêm vào giỏ hàng thành công" hoặc thông báo lỗi.

### 🌐 3.3 Gọi API để xử lý dữ liệu

React kết hợp với `axios` hoặc `fetch` để gửi request đến backend (Spring Boot) và hiển thị dữ liệu động theo tương tác người dùng. Ví dụ, khi người dùng nhấn vào một sản phẩm:

```jsx
useEffect(() => {
  axios.get(`/api/products/${id}`)
    .then(res => setProduct(res.data))
    .catch(err => console.error(err));
}, [id]);
```
Ứng dụng sử dụng API để:
- Lấy danh sách sản phẩm, thông tin chi tiết.
- Đăng nhập / đăng ký.
- Thêm, sửa, xoá đơn hàng.
- Hiển thị lịch sử mua hàng.

### 🔄 3.4 Giao tiếp giữa các component
React hỗ trợ truyền dữ liệu từ component cha xuống component con bằng props. Khi người dùng tương tác ở component con (ví dụ: chọn bộ lọc), callback sẽ truyền ngược dữ liệu lên để xử lý. Việc này giúp đảm bảo UI luôn đồng bộ khi người dùng thao tác nhiều phần tử liên quan.

### 🗣️ 3.5 Hiển thị phản hồi người dùng (Feedback UI)
Giao diện cần hiển thị các phản hồi như:
- Loading spinner khi đang gọi API.
- Hiển thị thông báo lỗi nếu login sai thông tin.
- Xác nhận “thêm vào giỏ hàng thành công” bằng Snackbar hoặc Toast.

Thư viện Material UI, react-toastify được nhóm sử dụng để hiển thị các phản hồi này một cách đẹp mắt và rõ ràng.