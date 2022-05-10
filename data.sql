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



