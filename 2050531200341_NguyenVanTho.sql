create database tho_341
go 
use tho_341
go
drop table users
create table users
(id int primary key identity(1,1),
firstName nvarchar (15),
lastName nvarchar (15),
userName varchar(15) ,
pass varchar(15))
insert into users values
('tho','Nguyen','tho123','123')

drop table quanLiDoUong
create table quanLiDoUong
(id int primary key identity(1,1),
tenDoUong nvarchar(50) ,
loaiThucUong varchar(50),
donVi varchar(15),
soLuong int ,
giaTien money)
insert into quanLiDoUong values
('nuoc cam','nuoc giai khat',' chai',2,20000),
('bia','nuoc uong co con',' chai',1,15000),
('nuoc loc','nuoc giai khat',' chai',4,10000),
('nuoc mia','nuoc giai khat',' li',1,7000),
('nuoc ep dau','nuoc ep',' li',3,25000)
 