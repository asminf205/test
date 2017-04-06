GO
Create database SOF203
GO
use SOF203
GO
create table USERS (
Username nvarchar(50) NOT NULL PRIMARY KEY,
Password nvarchar (50) NOT NULL,
Role nvarchar(50)
)
GO
create table GRADE (
ID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
MASV nvarchar (50) NOT NULL,
Tienganh int NOT NULL,
Tinhoc int NOT NULL,
GDTC int NOT NULL
)
GO
create table STUDENTS (
MASV nvarchar(50) NOT NULL PRIMARY KEY,
Hoten nvarchar (50) NOT NULL,
Email nvarchar(50) NOT NULL,
SoDT nvarchar(15) NOT NULL,
Gioitinh bit NOT NULL,
Diachi nvarchar(50) NOT NULL,
Hinh nvarchar(50) NOT NULL,
)
BEGIN TRANSACTION
SET QUOTED_IDENTIFIER ON
SET ARITHABORT ON
SET NUMERIC_ROUNDABORT OFF
SET CONCAT_NULL_YIELDS_NULL ON
SET ANSI_NULLS ON
SET ANSI_PADDING ON
SET ANSI_WARNINGS ON
COMMIT
BEGIN TRANSACTION
GO
ALTER TABLE dbo.STUDENTS SET (LOCK_ESCALATION = TABLE)
GO
COMMIT
BEGIN TRANSACTION
GO
ALTER TABLE dbo.GRADE ADD CONSTRAINT
	FK_GRADE_STUDENTS FOREIGN KEY
	(
	MASV
	) REFERENCES dbo.STUDENTS
	(
	MASV
	) ON UPDATE  NO ACTION 
	 ON DELETE  NO ACTION 
	
GO
ALTER TABLE dbo.GRADE SET (LOCK_ESCALATION = TABLE)
GO
COMMIT
go
Insert into STUDENTS Values('SV001','Le Hoang Nam','namlhps04772@fpt.edu.vn','01222151710',0,'343 tinh lo 10','3.jpg')
Insert into STUDENTS Values('SV002','Nguyen Bao Anh','Anh@fpt.edu.vn','01225478941',1,'148 Hau Giang','2.png')
Insert into STUDENTS Values('SV003','Le Hoang Long','Long@fpt.edu.vn','01285151110',0,'192 Lac Long Quan','3.jpg')
Insert into STUDENTS Values('SV004','Le Thuy Linh','Linh@fpt.edu.vn','01221514815',1,'Long An','4.jpg')
go
Insert into GRADE(MASV,Tienganh,Tinhoc,GDTC) Values('SV001',10,10,10)
Insert into GRADE(MASV,Tienganh,Tinhoc,GDTC) Values('SV002',9,9,9)
Insert into GRADE(MASV,Tienganh,Tinhoc,GDTC) Values('SV003',8,8,8)
go
Insert into USERS Values('phunglv','321','giang vien')
Insert into USERS Values('namlh','321','can bo dao tao')
Insert into USERS Values('hanh','321','can bo dao tao')