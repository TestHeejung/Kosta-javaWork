use mytest;

drop table board;

create table board(
	board_no int primary key auto_increment, -- 글번호
	subject varchar(30) not null, -- 제목
	writer varchar(20) not null,-- 작성자
	content varchar(50) not null,-- 내용
	board_date datetime not null-- 등록일
); 

drop table board;
select * from board;

insert into board ( subject, writer, content, board_date) 
values ( 'db수업', '장희정', '데이터베이스관리', now());
insert into board ( subject, writer, content, board_date) 
values ( '자바수업', '이가현', '객체지향언어', now());
insert into board ( subject, writer, content, board_date) 
values ( 'jdbc수업', '이찬범', '자바와db연동', now());



-- 댓글
create table reply(
  reply_no int primary key auto_increment, -- 댓글번호
  reply_content varchar(100), -- 댓글내용
  board_no int , -- 댓글을 달 부모글번호
  reply_regdate datetime, -- 등록일
  foreign key(board_no) references board(board_no)
);

 

-- 샘플 테스트(부모의 1번 글에 댓글은 3개 달아본다)
select * from board;
select * from reply;

insert into reply(reply_content,board_no ,reply_regdate) values( '1번의 댓글 1', 1 , now());
insert into reply(reply_content,board_no ,reply_regdate) values( '1번의 댓글 2', 1 , now());
insert into reply(reply_content,board_no ,reply_regdate) values( '1번의 댓글 3', 1 , now());


select * from board join reply using(board_no)  where board_no=1;

