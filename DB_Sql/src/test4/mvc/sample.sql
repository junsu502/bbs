--javalink/javalink

create table db(
	num number(3) primary key,
	name varchar2(20),
	price number(7)
);

create sequence db_seq;

select * from db;
select * from db where num=2;