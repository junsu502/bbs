create table mms_member(
	id number,
	name varchar2(12),
	addr varchar2(50),
	nation varchar2(12),
	email varchar2(30),
	age number,
	constraint pk_mms_member primary key (id)
);

select * from mms_member;
create sequence mms_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1;

