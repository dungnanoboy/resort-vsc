-- Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS dunhuth;
USE dunhuth;


-- Tạo bảng Khách hàng mới với email làm khóa chính
CREATE TABLE Users (
    email VARCHAR(100) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(50) DEFAULT Null,
    mobile VARCHAR(20),
    address VARCHAR(255) DEFAULT Null,
    gender VARCHAR(20) DEFAULT Null,
    avatar VARCHAR(255) DEFAULT '.\\img\\blog\\author.png',
    role INT NOT NULL DEFAULT '1'
);

-- Tạo bảng Điều kiện phòng
CREATE TABLE RoomConditions (
    condition_id INT AUTO_INCREMENT PRIMARY KEY,
    condition_name VARCHAR(30)
);

-- Tạo bảng Danh mục loại phòng
CREATE TABLE RoomTypes (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name VARCHAR(100),
    condition_id INT,
    price_per_night DECIMAL(10, 2),
    abst TEXT,
    description TEXT,
    occupancy INT,
    room_image VARCHAR(255),
    FOREIGN KEY (condition_id) REFERENCES RoomConditions(condition_id)
);

-- Tạo bảng Phòng
CREATE TABLE Rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    type_id INT,
    room_name VARCHAR(255),
    status BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (type_id) REFERENCES RoomTypes(type_id)
);

-- Tạo bảng Trạng thái Đặt phòng
CREATE TABLE BookingState (
    state_id INT PRIMARY KEY,
    state_name VARCHAR(50)
);
-- Tạo bảng Đặt phòng
CREATE TABLE Bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100),
    room_id INT,
    check_in_date DATE NOT NULL,
    check_out_date DATE NOT NULL,
    total_price DECIMAL(10, 2),
    is_paid BOOLEAN NOT NULL DEFAULT FALSE,
    state_id INT NOT NULL DEFAULT 1,
    FOREIGN KEY (email) REFERENCES Users(email),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id),
    FOREIGN KEY (state_id) REFERENCES BookingState(state_id),
    CHECK (check_in_date < check_out_date)
);


-- Tạo bảng Mã khuyến mãi
CREATE TABLE PromoCodes (
    promo_id INT AUTO_INCREMENT PRIMARY KEY,
    promo_code VARCHAR(50),
    discount_percent DECIMAL(4, 2), -- Giá trị phần trăm giảm giá, ví dụ: 0.10 cho 10%
    start_date DATE,
    end_date DATE,
    information TEXT
);

-- Tạo bảng Thanh toán
CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT,
    payment_date DATE NOT NULL,
    payment_amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    promo_id INT,
    FOREIGN KEY (booking_id) REFERENCES Bookings(booking_id),
    FOREIGN KEY (promo_id) REFERENCES PromoCodes(promo_id)
);

-- Tạo bảng Danh mục Blog
CREATE TABLE BlogCategories (
    catblog_id INT AUTO_INCREMENT PRIMARY KEY,
    catblog_name VARCHAR(100)
);

-- Tạo bảng Blog với post_id tự động tăng và ON DELETE CASCADE cho category_id
CREATE TABLE Blogs (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    summary TEXT,
    author VARCHAR(100) NOT NULL,
    publish_date DATETIME NOT NULL,
    catblog_id INT,
    picture VARCHAR(255),
    emotion INT,
    FOREIGN KEY (catblog_id) REFERENCES BlogCategories(catblog_id) ON DELETE CASCADE
);

-- Tạo bảng Reviews (Đánh giá của Blog)
CREATE TABLE Reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100),
    post_id INT,
    rating INT,
    comment TEXT,
    releasedate DATETIME,
    FOREIGN KEY (email) REFERENCES Users(email) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES Blogs(post_id) ON DELETE CASCADE
);



-- Chèn bản ghi vào bảng RoomCondition
INSERT INTO RoomConditions (condition_id, condition_name) VALUES
(1, 'Basic Room Types'),
(2, 'Luxury Room Types'),
(3, 'Special Room Types');

-- Thêm các bản ghi vào bảng RoomTypes
INSERT INTO RoomTypes (type_id, type_name, condition_id, price_per_night, abst, description, occupancy, room_image)
VALUES 
(1, 'Standard Room', 1, 100.00, 'Basic amenities, budget-friendly', 'Tourists want to save money and do not require many high-end amenities.', 2, '.\\img\\rooms\\3.png'),
(2, 'Deluxe Room', 1, 150.00, 'Spacious, elegant interiors, sea view', 'Tourists want to save money and do not require many high-end amenities.', 2, '.\\img\\rooms\\2.png'),
(3, 'Family Room', 1, 200.00, 'Large space, multiple beds, family-friendly', 'Tourists want to save money and do not require many high-end amenities.', 4, '.\\img\\rooms\\1.png'),
(4, 'Bungalow', 2, 250.00, 'Beachside, nature-integrated design', 'Tourists want to save money and do not require many high-end amenities.', 2, '.\\img\\rooms\\1.png'),
(5, 'Suite', 2, 300.00, 'Separate living area, high-end furnishings', 'Tourists want to save money and do not require many high-end amenities.', 4, '.\\img\\rooms\\2.png'),
(6, 'Presidential Suite', 2, 500.00, 'Most luxurious, private butler, stunning views', 'Tourists want to save money and do not require many high-end amenities.', 6, '.\\img\\rooms\\3.png'),
(7, 'Villa', 2, 888.00, 'Private, multiple bedrooms, private pool', 'Tourists want to save money and do not require many high-end amenities.', 8, '.\\img\\rooms\\4.png'),
(8, 'Pool Villa Room', 3, 1000.00, 'Direct pool access, luxurious experience', 'Tourists want to save money and do not require many high-end amenities.', 2, '.\\img\\rooms\\1.png'),
(9, 'Luxury Ocean View Suite', 3, 169.00, 'Elegant design, sea view, premium amenities', 'Tourists want to save money and do not require many high-end amenities.', 4, '.\\img\\rooms\\2.png');

-- Chèn bản ghi vào bảng Rooms
INSERT INTO Rooms (room_id, type_id, room_name, status) VALUES
(1, 1, 'Standard Room 101', TRUE),
(2, 1, 'Standard Room 102', TRUE),
(3, 2, 'Deluxe Room 201', TRUE),
(4, 2, 'Deluxe Room 202', TRUE),
(5, 3, 'Family Room 301', TRUE),
(6, 3, 'Family Room 302', TRUE),
(7, 4, 'Bungalow 401', TRUE),
(8, 4, 'Bungalow 402', TRUE),
(9, 5, 'Suite 501', TRUE),
(10, 5, 'Suite 502', TRUE),
(11, 6, 'Presidential Suite 601', TRUE),
(12, 6, 'Presidential Suite 602', TRUE),
(13, 7, 'Villa 701', TRUE),
(14, 7, 'Villa 702', TRUE),
(15, 8, 'Pool Villa 801', TRUE),
(16, 8, 'Pool Villa 802', TRUE),
(17, 9, 'Luxury Ocean View Suite 901', TRUE),
(18, 9, 'Luxury Ocean View Suite 902', TRUE);

-- Chèn bản ghi vào bảng BlogCategories
INSERT INTO BlogCategories (catblog_id, catblog_name) VALUES
(1, 'Resaurant food'),
(2, 'Travel news'),
(3, 'Modern technology'),
(4, 'Product'),
(5, 'Inspiration'),
(6, 'Health Care');

-- Chèn bản ghi vào bảng Blogs
INSERT INTO Blogs (post_id, title, content, summary, author, publish_date, catblog_id, picture, emotion) VALUES
(1, 'Delicious Foods', 'Exploring the best restaurants in town.', 'Exploring the best restaurants in town.', 'John Doe', '2024-05-01 10:00:00', 1, '.\\img\\blog\\single_blog_1.png', 5),
(2, 'Gourmet Experience', 'A journey through gourmet food experiences.', 'Exploring the best restaurants in town.', 'Jane Smith', '2024-05-02 11:00:00', 1, '.\\img\\blog\\single_blog_2.png', 4),

(3, 'Top Travel Destinations', 'Discover the top travel destinations for this year.', 'Exploring the best restaurants in town.', 'Alice Brown', '2024-05-03 12:00:00', 2, '.\\img\\blog\\single_blog_3.png', 3),
(4, 'Travel Tips', 'Tips for safe and enjoyable travel.', 'Exploring the best restaurants in town.', 'Bob White', '2024-05-04 13:00:00', 2, '.\\img\\blog\\single_blog_4.png', 2),

(5, 'Tech Innovations', 'The latest innovations in technology.', 'Exploring the best restaurants in town.', 'Charlie Green', '2024-05-05 14:00:00', 3, '.\\img\\blog\\single_blog_5.png', 5),
(6, 'Modern Gadgets', 'A review of the latest gadgets.', 'Exploring the best restaurants in town.', 'Diana Blue', '2024-05-06 15:00:00', 3, '.\\img\\blog\\single_blog_1.png', 4),

(7, 'New Product Launch', 'Introducing our new product line.', 'Exploring the best restaurants in town.', 'Edward Black', '2024-05-07 16:00:00', 4, '.\\img\\blog\\single_blog_1.png', 5),
(8, 'Product Reviews', 'Customer reviews of our products.', 'Exploring the best restaurants in town.', 'Fiona Red', '2024-05-08 17:00:00', 4, '.\\img\\blog\\single_blog_2.png', 3),

(9, 'Inspirational Stories', 'Stories that inspire and motivate.', 'Exploring the best restaurants in town.', 'George Yellow', '2024-05-09 18:00:00', 5, '.\\img\\blog\\single_blog_3.png', 4),
(10, 'Life Lessons', 'Lessons learned from inspirational figures.', 'Exploring the best restaurants in town.', 'Helen Purple', '2024-05-10 19:00:00', 5, '.\\img\\blog\\single_blog_4.png', 5),

(11, 'Health Tips', 'Tips for maintaining good health.', 'Exploring the best restaurants in town.', 'Ivan Orange', '2024-05-11 20:00:00', 6, '.\\img\\blog\\single_blog_5.png', 3),
(12, 'Healthcare Advances', 'The latest advances in healthcare.', 'Exploring the best restaurants in town.', 'Julia Pink', '2024-05-12 21:00:00', 6, '.\\img\\blog\\single_blog_1.png', 4);

-- Chèn bản ghi vào bảng Customers
INSERT INTO Users (email, password, fullname, mobile, address, gender, avatar, role) VALUES
('john.doe@example.com', 'johnpassword', 'John Doe', '1234567890', '123 Main St, Springfield', 'Male', '.\\img\\comment\\comment_1.png', 1),
('jane.smith@example.com', 'janepassword', 'Jane Smith', '2345678901', '456 Elm St, Springfield', 'Female', '.\\img\\comment\\comment_2.png', 1),
('alice.jones@example.com', 'alicepassword', 'Alice Jones', '3456789012', '789 Oak St, Springfield', 'Female', '.\\img\\comment\\comment_3.png', 1),
('bob.brown@example.com', 'bobpassword', 'Bob Brown', '4567890123', '101 Pine St, Springfield', 'Male', '.\\img\\comment\\comment_2.png', 1),
('charlie.white@example.com', 'charliepassword', 'Charlie White', '5678901234', '202 Maple St, Springfield', 'Other', '.\\img\\comment\\comment_3.png', 1),
('admin@example.com', 'admin', 'Adminstrator', '999999', '123 hehehe', 'Other', '.\\img\\blog\\author.png', 0);

-- Chèn bản ghi vào bảng Reviews
INSERT INTO Reviews (review_id, email, post_id, rating, comment, releasedate) VALUES
(1, 'john.doe@example.com', 3, 5, 'Excellent blog post! Very informative.', '2024-05-20 10:00:00'),
(2, 'jane.smith@example.com', 3, 4, 'Great read, but could use more examples.', '2024-05-20 11:00:00'),
(3, 'alice.jones@example.com', 3, 3, 'It was okay, some parts were unclear.', '2024-05-20 12:00:00'),
(4, 'bob.brown@example.com', 3, 4, 'Good content, but a bit lengthy.', '2024-05-20 13:00:00'),
(5, 'charlie.white@example.com', 3, 5, 'Loved it! Keep up the good work.', '2024-05-20 14:00:00');

-- Chèn bản ghi vào bảng BookingState
INSERT INTO BookingState (state_id, state_name) VALUES
(1, 'pending'),
(2, 'approved'),
(3, 'canceling'),
(4, 'canceled');

-- Chèn bản ghi vào bảng Bookings
INSERT INTO Bookings (booking_id, email, room_id, check_in_date, check_out_date, total_price, is_paid) VALUES
(1, 'john.doe@example.com', 1, '2024-05-20', '2024-05-22', 1000.00, 1),
(2, 'jane.smith@example.com', 2, '2024-05-20', '2024-05-22', 1000.00, 1);

INSERT INTO Bookings (booking_id, email, room_id, check_in_date, check_out_date, total_price, is_paid) VALUES
(3, 'john.doe@example.com', 1, '2024-06-18', '2024-06-22', 1000.00, 1),
(4, 'jane.smith@example.com', 7, '2024-06-14', '2024-06-17', 1000.00, 1);

-- Chèn dữ liệu vào bảng PromoCodes
INSERT INTO PromoCodes (promo_code, discount_percent, start_date, end_date, information)
VALUES ('PROMO10', 0.10, '2024-06-01', '2024-06-30', '10% Discount'),
       ('PROMO20', 0.20, '2024-06-01', '2024-06-30', '20% Discount'),
       ('PROMO50', 0.50, '2024-06-01', '2024-06-30', '50% Discount');

-- Thêm bản ghi vào bảng Payments
INSERT INTO Payments (booking_id, payment_date, payment_amount, payment_method, promo_id)
VALUES 
    (3, '2024-06-15', 900.00, 'Credit Card', 1),
    (4, '2024-06-12', 800.00, 'Debit Card', 2);


-- Kiểm tra trạng thái của Event Scheduler:
SHOW VARIABLES LIKE 'event_scheduler';

-- Kích hoạt Event Scheduler:
SET GLOBAL event_scheduler = ON;

-- Tạo sự kiện cập nhật trạng thái phòng:
DELIMITER $$

CREATE EVENT UpdateRoomStatus
ON SCHEDULE EVERY 1 MINUTE
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    -- Cập nhật trạng thái phòng thành false nếu hiện tại đang trong khoảng thời gian đặt phòng
    UPDATE Rooms r
    JOIN Bookings b ON r.room_id = b.room_id
    SET r.status = FALSE
    WHERE CURDATE() BETWEEN b.check_in_date AND b.check_out_date
      AND b.is_paid = TRUE;

    -- Cập nhật trạng thái phòng thành true nếu hiện tại không nằm trong khoảng thời gian đặt phòng
    UPDATE Rooms r
    LEFT JOIN Bookings b ON r.room_id = b.room_id AND CURDATE() BETWEEN b.check_in_date AND b.check_out_date
    SET r.status = TRUE
    WHERE b.room_id IS NULL;
END$$

DELIMITER ;

-- Tạo sự kiện huỷ đặt phòng chưa trả tiền:
DELIMITER $$

CREATE EVENT DeleteUnpaidBookings
ON SCHEDULE EVERY 1 DAY
STARTS CURRENT_TIMESTAMP
DO
BEGIN
    DELETE FROM Bookings
    WHERE CURDATE() = DATE_SUB(check_in_date, INTERVAL 1 DAY)
      AND is_paid = FALSE;
END$$

DELIMITER ;

-- Kiểm tra trạng thái và chi tiết sự kiện:
SHOW EVENTS;










