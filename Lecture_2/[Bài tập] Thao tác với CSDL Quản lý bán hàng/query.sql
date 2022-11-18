insert into customer (cName,cAge)
value ('Minh Quan', 10),
	('Ngoc Oanh',20),
    ('Hong Ha',50);
    
insert into orders (cID,oDate)
value(1,'2006-03-21'),
	(2,'2006-03-23'),
    (1,'2006-03-16');
	
insert into product (pName,pPrice)
value('May Giat',3),
	('Tu Lanh',5),
    ('Dieu Hoa',7),
    ('Quat',1),
    ('Bep Dien',2);
    
insert into ordersdetails (oID,pID,odQTY)
value(1,1,3),
	(1,3,7),
    (1,4,2),
    (2,1,1),
    (3,1,8),
    (2,5,4),
    (2,3,3);
    
-- Hiển thị các thông tin gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select ordersdetails.oID as 'order id', ordersdetails.pID as 'product id',product.pName, ordersdetails.odQTY as quantity, orders.oDate as date, ordersdetails.odQTY * product.pPrice as price
from ordersdetails join orders on ordersdetails.oID = orders.oID join product on ordersdetails.pID = product.pID;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select orders.cID, customer.cName, product.pName from orders
join customer on orders.cId = customer.cID join ordersdetails on orders.oID = ordersdetails.oID
join product on ordersdetails.pID = product.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customer.cID, customer.cName from customer where customer.cID not in (select orders.cId from orders);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn
select ordersdetails.oID, sum(ordersdetails.odQTY * product.pPrice) as total_price, orders.odate from ordersdetails
join product on ordersdetails.pID = product.pID join orders on ordersdetails.oID = orders.oID
group by ordersdetails.oID;
