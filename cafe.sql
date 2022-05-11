CREATE DATABASE ql_cafe;
go

USE ql_cafe;
go
CREATE TABLE account (
	ID int NOT NULL IDENTITY(1,1) PRIMARY KEY,
	username varchar(200) NOT NULL,
	matkhau varchar(200) NOT NULL,
	ten varchar(255) NOT NULL
)
go
CREATE TABLE drinks (
  ID_d int NOT NULL IDENTITY(4,1) PRIMARY KEY,
  ten_d nvarchar(200) NOT NULL,
  price int NOT NULL,
  starts_date date DEFAULT NULL,
  end_date date DEFAULT NULL
)
CREATE TABLE tablez(
  ID_t int NOT NULL IDENTITY(1,1) PRIMARY KEY,
  table_name varchar(250) ,
  note text ,
  status_t tinyint NOT NULL
)
CREATE TABLE invoice (
  ID_i int NOT NULL IDENTITY(8,1) PRIMARY KEY,
  account_ID int NOT NULL constraint FK_invoice_accountid foreign key references account(ID)
							on delete cascade on update cascade,
  invoice_date datetime  NOT NULL,
  tables_id int NOT NULL constraint FK_invoice_tableid foreign key references tablez(ID_t)
							on delete cascade on update cascade,
  status_i int NOT NULL,
  total_price int DEFAULT 0 NOT NULL
) 
CREATE TABLE orders (
  ID_o int NOT NULL IDENTITY(13,1) PRIMARY KEY,
  drinks_ID int NOT NULL constraint orders_ibfk_1 foreign key references drinks (ID_d)
							on delete cascade on update cascade,
  counts int NOT NULL,
  invoice_ID int NOT NULL constraint orders_ibfk_3 foreign key references invoice (ID_i)
							on delete cascade on update cascade,
)
ALTER TABLE invoice ADD CONSTRAINT DF_invoice DEFAULT GETDATE() FOR invoice_date
go

insert into account (username, matkhau, ten)
values	( 'admin', 'admin', 'Admin'),
( 'thinh123', '123456', 'Thinh'),
( 'tho123', '123456', 'Tho');
go

insert into drinks (ten_d,price,starts_date,end_date)
values	( 'Cà phê', 40000, '2022-01-01', '2022-12-12'),
( N'Trà sữa', 30000, '2022-01-01', '2022-12-12'),
( 'Cà phê đen', 20000, '2022-01-01', '2022-06-06'),
( 'Cà phê đá', 40000, '2022-01-12', '2022-01-31');
go

insert into tablez (table_name,note,status_t)
values	( N'Bàn 1', '', 0),
( N'Bàn 2', '', 0),
( N'Bàn 3', '', 0),
( N'Bàn 4', '', 0),
( N'Bàn 5', N'5 người', 0);
go

insert into invoice (account_ID,invoice_date,tables_id,status_i,total_price)
values	( 1, '2018-01-05 00:04:50', 1, 1, 260000),
( 1, '2018-01-05 00:04:47', 2, 1, 200000),
( 1, '2018-01-05 00:04:43', 5, 1, 170000),
( 1, '2018-01-05 00:07:15', 2, 1, 300000);
go

insert into orders (drinks_ID,counts,invoice_ID)
values	( 4, 1, 8),
( 6, 1, 8),
( 5, 1, 9),
( 7, 1, 10),
( 6, 1, 11),
( 4, 1, 11),
( 5, 1, 11),
( 7, 1, 11);
go