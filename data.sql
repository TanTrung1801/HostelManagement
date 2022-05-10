CREATE DATABASE HostelManagement
GO
DROP DATABASE HostelManagement

USE HostelManagement
GO

---Table RoleID---
DROP TABLE tblRole
CREATE TABLE tblRole(
	roleID nvarchar(50) PRIMARY KEY,
	roleName nvarchar(50)
)


---Table User---
DROP TABLE tblUsers
CREATE TABLE tblUsers(
	userID nvarchar(50) PRIMARY KEY,
	userPassword nvarchar(50),
	userName nvarchar(50),
	userPhone text,
	userEmail nvarchar(255),
	userCMND text,
	dateOfBirth date,
	roleID nvarchar(50),
	userStatus bit,
	FOREIGN KEY (roleID) REFERENCES tblRole(roleID)
)

---Table Category---
DROP TABLE tblCategory
CREATE TABLE tblCategory(
	categoryID nvarchar(20) PRIMARY KEY,
	categoryName nvarchar(50)
)

---Table Service---
DROP TABLE tblService
CREATE TABLE tblService(
	serviceID nvarchar(20) PRIMARY KEY,
	serviceName nvarchar(50)
)

---Table Hostel---
DROP TABLE tblHostel
CREATE TABLE tblHostel(
	hostelID nvarchar(50) PRIMARY KEY,
	userID nvarchar(50),
	hostelAddress nvarchar(255),
	hostelSize float,
	hostelPrice float,
	hostelImage nvarchar(max),
	numOfRooms int,
	categoryID nvarchar(20),
	serviceID nvarchar(20),
	hostelDescription nvarchar(max),
	FOREIGN KEY (userID) REFERENCES tblUsers(userID),
	FOREIGN KEY (categoryID) REFERENCES tblCategory(categoryID),
	FOREIGN KEY (serviceID) REFERENCES tblService(serviceID)
)

---Table Contract---
DROP TABLE tblContract
CREATE TABLE tblContract(
	contractID nvarchar(50),
	hostelPrice float PRIMARY KEY,
	hostelID nvarchar(50),
	userID nvarchar(50), 
	dateStart date,
	dateEnd date,
	FOREIGN KEY (hostelID) REFERENCES tblHostel(hostelID),
	FOREIGN KEY (userID) REFERENCES tblUsers(userID)
)

---Table Order detail---
DROP TABLE tblOrderDetail
CREATE TABLE tblOrderDetail(
	detailID nvarchar(50) PRIMARY KEY,
	hostelPrice float,
	surcharge float, ---phụ phí---
	descript nvarchar(max),  ---mô tả---
	FOREIGN KEY (hostelPrice) REFERENCES tblContract(hostelPrice)
)

---Table Order---
DROP TABLE tblOrder
CREATE TABLE tblOder(
	orderID nvarchar(20) PRIMARY KEY,
	detailID nvarchar(50),
	hostelID nvarchar(50),
	userID nvarchar(50),
	datePay date,
	sumPrice float,
	FOREIGN KEY (detailID) REFERENCES tblOrderDetail(detailID),
	FOREIGN KEY (hostelID) REFERENCES tblHostel(HostelID),
	FOREIGN KEY (userID) REFERENCES tblUsers(userID)
)
--- insert ---
GO
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'CC', N'Chung Cư ')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'NT', N'Nhà Trọ')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'PT', N'Phòng Trọ')
GO
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT01', N'chunha01', N'112/4 Trần Xuân Soạn, Quận 7, Tp.Hồ Chí MInh', 80, 4, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/05/06/9e7f4855-ccfb-44ea-b829-6312adaae48d_1651816095.jpg', 4, N'NT', N'NB', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT02', N'chunha01', N'1/87 Liên Phường, phường Hiệp Bình Phước, Tp.Thủ Đức ', 90, 5, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/05/09/4fd2ccab-6aeb-480b-ba81-6ee5a5ef18fc_1652094367.jpg', 4, N'NT', N'NB', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT03', N'chunha02', N'71A Đường Tuệ Tĩnh, Phường Nguyễn Du, Quận Hai Bà Trưng, TP.Hà Nội', 90, 5, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/05/06/z3393643430812-33a6b86d66fcf93a29ac057e43850200_1651824397.jpg', 4, N'NT', N'NB', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT04', N'chunha02', N'137 Đường Nguyễn Văn Cừ, Long Biên, TP.Hà Nội ', 120, 7, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/05/06/z3393643422769-42c426cb3b38793cf28a6896b912bf31_1651824397.jpg', 4, N'NT', N'NB', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT05', N'chunha03', N'187 Bạch Đằng, Phường 2, Quận Tân Bình, Tp.Hồ Chí MInh', 72, 3.5, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/04/28/z2481594162842-a9d02e53efdd508b55dda0242a25b8ae_1651115909.jpg', 3, N'NT', N'ML', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT06', N'chunha03', N'108-110 Nguyễn Trãi, Phường Bến Thành, Quận 1, Tp. Hồ Chí Minh ', 58, 2.3, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/04/28/z2377180264737-03560b81d698478311a42de65cd7f5bb_1651115908.jpg', 2, N'PT', N'ML', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT07', N'user01', N'38/1/95 Trường Chinh, Phường 15, Quận Tân Bình, Tp.Hồ Chí MInh', 30, 1.5, N'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.hancorp.com.vn%2Fxu-huong-xay-phong-tro-cho-thue-hap-dan-gioi-dau-tu%2F&psig=AOvVaw2jaKGYNyii8xvSMN2-65gW&ust=1652297049878000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCKD_qarU1fcCFQAAAAAdAAAAABAD', 1, N'PT', N'WIFI', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT08', N'user02', N'50/4 Đỗ Tân Phòng, Phường 9, Quận Phú Nhuận, Hồ Chí Minh', 35, 1.7, N'https://www.google.com/url?sa=i&url=https%3A%2F%2Fnhatrotot.com%2Fnha-tro-phong-tro-cho-thue-uong-me-tri-ha-tu-liem-cd0113019&psig=AOvVaw1UWAVOWo99ONZ7U7U0dyRp&ust=1652297102520000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCPD3v8HU1fcCFQAAAAAdAAAAABAK', 1, N'PT', N'WIFI', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT09', N'user03', N'GF02 - Business Center, 57 - 59 Hồ Tùng Mậu, Phường Bến Nghé, Quận 1, Tp.Hồ Chí Minh', 70, 3, N'https://pt123.cdn.static123.com/images/thumbs/900x600/fit/2022/05/04/z3387803522823-0acd1c6d1457daabc1c71fe4d18301d9_1651635989.jpg', 3, N'CC', N'GX', NULL)
INSERT [dbo].[tblHostel] ([hostelID], [userID], [hostelAddress], [hostelSize], [hostelPrice], [hostelImage], [numOfRooms], [categoryID], [serviceID], [hostelDescription]) VALUES (N'HT10', N'user04', N'155 Tô Hiến Thành, Quận 10, tp.HCM', 40, 2, N'https://www.google.com/url?sa=i&url=http%3A%2F%2Fwww.timphongtro.vn%2Ftim-nha-tro-phong-tro-duong-truong-chinh-phuong-tan-hung-thuan%2Fcho-thue-5-phong-tro%25C2%25A0hinh-anh-o-duoi-la-chua-gan-noi-that-va-da-gan-noi-that-dac-biet-co-gan-them-noi-that-theo-yeu-cau-23148&psig=AOvVaw3tbRkanilRbwLDCS-kDStR&ust=1652297211611000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCNi7jfXU1fcCFQAAAAAdAAAAABAQ', 2, N'PT', N'ML', NULL)
GO
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'AD', N'ADMIN ')
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'US', N'User')
GO
INSERT [dbo].[tblService] ([serviceID], [serviceName]) VALUES (N'GX', N'Giữ Xe')
INSERT [dbo].[tblService] ([serviceID], [serviceName]) VALUES (N'HB', N'Hồ Bơi')
INSERT [dbo].[tblService] ([serviceID], [serviceName]) VALUES (N'ML', N'Máy Lạnh ')
INSERT [dbo].[tblService] ([serviceID], [serviceName]) VALUES (N'NB', N'Nhà Bếp ')
INSERT [dbo].[tblService] ([serviceID], [serviceName]) VALUES (N'WIFI', N'Internet Wifi')
GO
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'admin01', N'123', N'Phạm Việt Tân', N'0839306108 ', N'viettan.pham81@yahoo.com', N'0790819130', CAST(N'1981-08-14' AS Date), N'AD', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'admin02', N'123', N'Bùi Hữu Phước', N'0838251829 ', N'huuphuoc_bui27@hotmail.com', N'
0790438505', CAST(N'1943-04-06' AS Date), N'AD', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'admin03', N'123', N'Nguyễn Xuân Trang', N'0862589602 ', N'xuantrang31@gmail.com', N'
0791469653', CAST(N'1946-06-14' AS Date), N'AD', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'chunha01', N'123', N'Đặng Diễm Hạnh', N'0837620030 ', N'diemhanh.dang@yahoo.co', N'
0791556966', CAST(N'1955-01-30' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'chunha02', N'123', N'Tô Đông Quân', N'0963941401', N'dongquan_to@gmail.com', N'0010526750', CAST(N'1952-08-04' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'chunha03', N'123', N'Trần Thành Vinh', N'0943821510 ', N'thanhvinh43@gmail.com', N'
0792046051', CAST(N'2004-01-15' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user01', N'123', N'Đào Thúy Nương', N'0938205897', N'thuynuong.dao@yahoo.com', N'0773004516', CAST(N'2000-08-27' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user02', N'123', N'Lê Phú Hùng', N'0839607822 ', N'phuhung.le83@yahoo.com', N'0742017637', CAST(N'2001-03-25' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user03', N'123', N'Mai Hương Ly', N'0922250834', N'huongly.mai@gmail.com', N'0041938203', CAST(N'1993-06-29' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user04', N'123', N'Vương Đức Tài', N'0348284534 ', N'ductai.vuong@hotmail.com', N'0020940805', CAST(N'1994-03-30' AS Date), N'US', 1)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user05', N'123', N'Nguyễn Minh Hằng', N'0939784125', N'minhhang70@hotmail.com', N'0931879492', CAST(N'1987-04-21' AS Date), N'US', 0)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user06', N'123', N'Đoàn Vân Anh', N'0838223996', N'vanganh_doan31@yahoo.com', N'0941842788', CAST(N'1984-11-09' AS Date), N'US', 0)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user07', N'123', N'Nguyễn Thị Kim Quyền', N'0338554006 ', N'kimquyen73@gmail.com', N'0951988896', CAST(N'1998-06-17' AS Date), N'US', 0)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user08', N'123', N'Tăng Ngọc Anh', N'0843832177', N'anhngoc_tang@yahoo.com', N'0923026871', CAST(N'2002-02-01' AS Date), N'US', 0)
INSERT [dbo].[tblUsers] ([userID], [userPassword], [userName], [userPhone], [userEmail], [userCMND], [dateOfBirth], [roleID], [userStatus]) VALUES (N'user09', N'123', N'Vũ Minh Vương ', N'0986658164', N'minhvuong.vu@hotmail.com', N'0482038992', CAST(N'2003-06-15' AS Date), N'US', 0)


