# Hướng dẫn cấu hình Chatbot với Gemini API

## Bước 1: Lấy Gemini API Key miễn phí

1. Truy cập [Google AI Studio](https://aistudio.google.com/)
2. Đăng nhập bằng tài khoản Google
3. Tại trang chủ, click vào "Get API key" hoặc "Create API key"
4. Tạo một project mới hoặc chọn project có sẵn
5. Click "Create API key" và copy key được tạo

## Bước 2: Cấu hình API Key

Mở file `src/main/webapp/js/chatbot.js` và thay thế dòng:
```javascript
this.apiKey = 'YOUR_GEMINI_API_KEY';
```

Thành:
```javascript
this.apiKey = 'YOUR_ACTUAL_API_KEY_HERE';
```

## Bước 3: Tính năng của Chatbot

### Tính năng chính:
- **Giao diện đẹp**: Thiết kế hiện đại với animation mượt mà
- **Responsive**: Tương thích với mobile và desktop
- **AI thông minh**: Tích hợp Gemini API cho câu trả lời thông minh
- **Fallback responses**: Có câu trả lời mặc định khi API không khả dụng
- **Context-aware**: Hiểu ngữ cảnh về resort và dịch vụ

### Chức năng hỗ trợ:
- ✅ Thông tin phòng và giá cả
- ✅ Hướng dẫn đặt phòng
- ✅ Thông tin dịch vụ resort
- ✅ Thông tin liên hệ
- ✅ Tour du lịch và hoạt động
- ✅ Câu hỏi về ẩm thực

## Bước 4: Tùy chỉnh

### Thay đổi màu sắc:
Trong file `css/chatbot.css`, tìm và thay đổi:
```css
background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
```

### Thay đổi vị trí chatbot:
Trong file `css/chatbot.css`, tìm `.chatbot-container` và thay đổi:
```css
bottom: 20px;  /* Khoảng cách từ đáy */
right: 20px;   /* Khoảng cách từ bên phải */
```

### Thay đổi thông tin resort:
Trong file `js/chatbot.js`, tìm function `createPrompt()` và cập nhật thông tin.

## Bước 5: Test Chatbot

1. Build và chạy project Maven
2. Truy cập website
3. Nhìn thấy nút chatbot ở góc phải dưới màn hình
4. Click để mở chat và test các câu hỏi:
   - "Cho tôi biết về các loại phòng"
   - "Làm sao để đặt phòng?"
   - "Địa chỉ resort ở đâu?"
   - "Có những dịch vụ gì?"

## Troubleshooting

### Nếu chatbot không hiển thị:
- Kiểm tra console browser có lỗi JavaScript không
- Đảm bảo file CSS và JS được load đúng
- Kiểm tra đường dẫn file trong footer.jsp

### Nếu API không hoạt động:
- Kiểm tra API key có đúng không
- Kiểm tra network connection
- Xem console có lỗi CORS không

### Nếu response chậm:
- Gemini API miễn phí có giới hạn rate limit
- Chatbot sẽ tự động fallback về response mặc định

## Mở rộng tính năng

Bạn có thể thêm:
- Kết nối với database để lấy thông tin phòng trống
- Tích hợp với booking system
- Thêm voice chat
- Multi-language support
- Analytics để track user interactions

---

**Lưu ý**: API key Gemini miễn phí có giới hạn. Đối với production, nên sử dụng paid plan hoặc implement caching để tối ưu số lượng API calls.
