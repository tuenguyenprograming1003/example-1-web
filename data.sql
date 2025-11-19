CREATE DATABASE IF NOT EXISTS webpr330479 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE webpr330479;

CREATE TABLE IF NOT EXISTS `User` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  username VARCHAR(100) NOT NULL UNIQUE,
  fullname VARCHAR(255),
  password VARCHAR(255) NOT NULL,
  avatar VARCHAR(255),
  roleid INT DEFAULT 3,
  phone VARCHAR(20),
  createdDate DATE
);

INSERT INTO `User` (email, username, fullname, password, avatar, roleid, phone, createdDate)
VALUES ('admin@example.com', 'admin', 'Administrator', '123456', NULL, 1, '0123456789', CURDATE());

INSERT INTO `User` (email, username, fullname, password, avatar, roleid, phone, createdDate)
VALUES ('user@example.com', 'user', 'Normal User', '123456', NULL, 3, '0987654321', CURDATE());
