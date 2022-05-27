CREATE DATABASE UserHostel
USE UserHostel
GO
DROP TABLE tblUsers
CREATE TABLE tblUsers(
	userID nvarchar(250) PRIMARY KEY,
	password nvarchar(250),
	roleID nvarchar(250),
	fullName nvarchar(250),
	email nvarchar(250),
	phoneNumber nvarchar(250),
	IDcard nvarchar(250),
	DoB date,
	status bit
)

INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES ('T01', '1','US',N'Nguyễn Tấn Trung','nguyentantrung9179@gmail.com','0969920894','212489033','2001/01/18',1)
INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES ('T02', '1','US',N'Trương Thành Trung','trungtruong@gmail.com','0969920894','212488033','2005/06/18',1)
INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES ('T03', '1','US',N'Nguyễn Tấn Tài','tantai@gmail.com','0123456789','212589033','2001/05/18',1)
INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES ('T04', '1','US',N'Trần Bình Trọng','nguyentrong558@gmail.com','0123456789','212779033','2008/06/28',1)
INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES ('T05', '1','US',N'Bùi Thị Bích Phượng','phuongbui001@gmail.com','0123456789','212489033','2002/12/13',1)
INSERT INTO tblUsers(userID, password, roleID, fullName, email, phoneNumber, IDcard, DoB, status) VALUES ('admin', '1801','AD',N'Admin','','','','2001/01/18',1)
