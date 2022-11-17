-- use quan_ly_ban_hang;
-- create table Customer(
-- cID int auto_increment primary key,
-- cName varchar(50),
-- cAge int
-- );

-- create table Product(
-- pID int auto_increment primary key,
-- pName varchar(50),
-- pPrice float
-- );

create table Orders(
oID int auto_increment primary key,
cID int,
oDate datetime,
oTotalPrice float,
Foreign key(cID) references Customer(cID)
);

create table OrdersDetails(
oID int,
pID int,
odQTY int,
Primary key (oID, pID),
Foreign key (oID) references Orders(oID),
Foreign key (pID) references product(pID)
);