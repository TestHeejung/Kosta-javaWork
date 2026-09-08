drop table customer;
-- 고객테이블
create table customer(
  user_id varchar(30) primary key, -- 사용자ID
  user_pwd varchar(30) not null,-- 비밀번호
  user_name varchar(30),-- 이름
  reg_date date-- 가입일
);


insert into  customer values('jang','1111','유재석',now());
insert into  customer values('lee','1111','이효리',now());
insert into  customer values('kim','1111','송중기',now());
insert into  customer values('king','1111','송혜교',now());

-- 상품테이블
create table goods(
  goods_id varchar(20) primary key, -- 상품번호
  goods_name varchar(50) not null, -- 상품이름
  goods_price int ,-- 가격
  stock int, -- 재고량
  regdate datetime default now() -- 등록일
);


insert into goods values('A01','새우깡',1500,10,now());
insert into goods values('A02','허니버터칩',2500,10,now());
insert into goods values('A03','콘칩',2000,10,now());
insert into goods values('A04','빼빼로',1500,10,now());
insert into goods values('A05','감자깡',1500,10,now());

delete from goods;

-- 주문테이블
drop table orders;

create table orders(
  order_id int primary key auto_increment, -- 주문코드
  order_date datetime not null, -- 주문일자
  user_id varchar(30) not null  , -- 주문한사람
  address varchar(100) not null, -- 배송지
  total_amount int not null, -- 총구매금액
  foreign key(user_id) references customer(user_id)
);



-- 주문상세
create table order_line(
  order_line_id int primary key auto_increment, -- 주문상세코드
  order_id int not null , -- 주문코드(주문아이디)
  goods_id varchar(20) not null , -- 상품아이디
  unit_price int not null, -- 단가
  qty int not null, -- 주문수량
  amount int not null, -- 단가*주문수량 한 금액
  foreign key(order_id) references orders(order_id) , 
  foreign key(goods_id) references goods(goods_id)
);

-- ---------------------------------------------------------------------
select * from orders;
-- 주문하기
 -- 1) jang 아이디가 A01 상품 2개, AO2 상품 1개 구입한다.
  INSERT INTO ORDERS(ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(now(),'jang','경기도 판교', 5500);
  
  -- 방금 삽입한 order_id 값 가져오기
SET @order_id = LAST_INSERT_ID();
  
insert into order_line(order_id, goods_id,unit_price, qty, amount)
values(@order_id , 'A01', 1500,2 , 3000 );
  
insert into order_line(order_id, goods_id,unit_price, qty, amount)
values(@order_id , 'A02', 2500,1 , 2500 );
  
  
  -- 주문수량만큼 재고량 감소시킨다.
  update goods set stock=stock-2 where goods_id='A01';
  update goods set stock=stock-1 where goods_id='A02';
 
 commit;
 
 select * from orders;
 select * from order_line;
 
 drop table order_line;
 drop table orders;
 
 -- 2) KIM 아이디가 A01 상품 3개 구입한다.
   INSERT INTO ORDERS( ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(now(),'kim','서울시 강남구', 4500);
  
    -- 방금 삽입한 order_id 값 가져오기
SET @order_id = LAST_INSERT_ID();

  insert into order_line(order_id, goods_id,unit_price, qty, amount)
  values(@order_id, 'A01', 1500,3 , 4500 );
  
  update goods set stock=stock-3 where goods_id='A01';
  

 
 -- 3) JANG 아이디가 A03 상품 2개와 A04 상품 1개 구입한다.
  INSERT INTO ORDERS( ORDER_DATE,USER_ID, ADDRESS, TOTAL_AMOUNT)
  VALUES(now(),'jang','경기도 분당구', 5500);
  
    -- 방금 삽입한 order_id 값 가져오기
SET @order_id = LAST_INSERT_ID();

  insert into order_line(order_id, goods_id,unit_price, qty, amount)
  values(@order_id , 'A03', 2000,2 , 4000 );
  
   insert into order_line(order_id, goods_id,unit_price, qty, amount)
  values( @order_id , 'A04', 1500,1 , 1500 );
  
  update goods set stock=stock-2 where goods_id='A03';
  update goods set stock=stock-1 where goods_id='A04';
  
  -- -----------------------------------------------------
  select * from customer;
  select * from goods;
  select * from orders;
  select * from order_line;
  
  
   drop table order_line;
  drop table orders;
  drop table goods;
  drop table customer;
  

  
  
  