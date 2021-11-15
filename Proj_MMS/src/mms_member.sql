create table mms_member(
	id number,
	name varchar2(12) not null,
	addr varchar2(50) not null,
	nation varchar2(12) not null,
	email varchar2(30) not null,
	age number,
	constraint pk_mms_member primary key(id)
);
select * from mms_member;

create sequence meber_id_seq
