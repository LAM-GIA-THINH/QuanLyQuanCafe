CREATE DATABASE ql_cafe;
go

USE ql_cafe;
go
CREATE TABLE account (
	ID int NOT NULL PRIMARY KEY,
	username varchar(200) NOT NULL,
	matkhau varchar(200) NOT NULL,
	ten varchar(255) NOT NULL
)
go
CREATE TABLE drinks (
  ID_d int NOT NULL PRIMARY KEY,
  ten_d nvarchar(200) NOT NULL,
  price int NOT NULL,
  starts_date date DEFAULT NULL,
  end_date date DEFAULT NULL
)
CREATE TABLE tablez(
  ID_t int NOT NULL PRIMARY KEY,
  table_name varchar(250) ,
  note text ,
  status_t tinyint NOT NULL
)
CREATE TABLE invoice (
  ID_i int NOT NULL PRIMARY KEY,
  account_ID int NOT NULL constraint FK_invoice_accountid foreign key references account(ID)
							on delete cascade on update cascade,
  invoice_date datetime  NOT NULL,
  tables_id int NOT NULL constraint FK_invoice_tableid foreign key references tablez(ID_t)
							on delete cascade on update cascade,
  status_i int NOT NULL,
  total_price int DEFAULT 0 NOT NULL
) 
CREATE TABLE orders (
  ID_o int NOT NULL PRIMARY KEY,
  drinks_ID int NOT NULL constraint orders_ibfk_1 foreign key references drinks (ID_d)
							on delete cascade on update cascade,
  counts int NOT NULL,
  invoice_ID int NOT NULL constraint orders_ibfk_3 foreign key references invoice (ID_i)
							on delete cascade on update cascade,
)
ALTER TABLE invoice ADD CONSTRAINT DF_invoice DEFAULT GETDATE() FOR invoice_date
go

insert into account
values	(1, 'admin', 'admin', 'Admin'),
(2, 'thinh123', '123456', 'Thinh'),
(3, 'tho123', '123456', 'Tho');
go

insert into drinks
values	(4, 'Cà phê', 40000, '2022-01-01', '2022-12-12'),
(5, N'Trà sữa', 30000, '2022-01-01', '2022-12-12'),
(6, 'Cà phê đen', 20000, '2022-01-01', '2022-06-06'),
(7, 'Cà phê đá', 40000, '2022-01-12', '2022-01-31');
go

insert into tablez
values	(1, N'Bàn 1', '', 0),
(2, N'Bàn 2', '', 0),
(3, N'Bàn 3', '', 0),
(4, N'Bàn 4', '', 0),
(5, N'Bàn 5', N'5 người', 0);
go

insert into invoice
values	(8, 1, '2018-01-05 00:04:50', 1, 1, 260000),
(9, 1, '2018-01-05 00:04:47', 2, 1, 200000),
(10, 1, '2018-01-05 00:04:43', 5, 1, 170000),
(11, 1, '2018-01-05 00:07:15', 2, 1, 300000);
go

insert into orders
values	(13, 4, 1, 8),
(14, 6, 1, 8),
(15, 5, 1, 9),
(16, 7, 1, 10),
(17, 6, 1, 11),
(18, 4, 1, 11),
(19, 5, 1, 11),
(20, 7, 1, 11);
go