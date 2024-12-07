-- member
insert into member values ( 1, 'a', 'a1' );
insert into member values ( 2, 'b', 'b1' );


-- goods
insert into goods(id, name, price, quantity, status, created_at, seller_id) values ( 1, '아이스 아메리카노', 4500, 100, 'ON_SALE', '2024-12-07 18:44:12', 1);
insert into goods(id, name, price, quantity, status, created_at, seller_id) values ( 2, '아이스 라뗴', 5000, 100, 'RESERVED', '2024-12-07 18:44:13', 1);
insert into goods(id, name, price, quantity, status, created_at, seller_id) values ( 3, '아이스 라뗴', 5000, 100, 'COMPLETED', '2024-12-07 18:44:13', 2);


-- orders
insert into orders(ID,BUYER_ID,GOODS_ID,QUANTITY,PRICE, ORDER_STATUS,CREATE_AT)values (1, 2, 1, 2, 9000, 'APPROVED', '2024-12-07 18:44:13');
insert into orders(ID,BUYER_ID,GOODS_ID,QUANTITY,PRICE, ORDER_STATUS,CREATE_AT)values (2, 2, 2, 2, 10000, 'PENDING_APPROVAL', '2024-12-10 18:44:13');
insert into orders(ID,BUYER_ID,GOODS_ID,QUANTITY,PRICE, ORDER_STATUS,CREATE_AT)values (3, 1, 3, 2, 1000, 'PENDING_APPROVAL', '2024-12-11 18:44:13');
