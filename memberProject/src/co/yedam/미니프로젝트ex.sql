-- 사원테이블(사원번호, 사원명, 연락처, 이메일, 입사일자
drop table emp purge;

create table emp (
 emp_no        number        primary key -- emp_seq.netxtval
,emp_name     varchar2(40)  not null
,emp_phone    varchar2(12)  not null -- 02-1234-1234
,email            varchar2(30)   not null
,hire_date       date default   sysdate
,salary            number
);
-- C(reate) , R(ead) , U(pdate) , D(elete)
create sequence emp_seq;
insert into emp (emp_no, emp_name, emp_phone, email, salary)
values(emp_seq.nextval, 'kildonghong', '01-1234-5678', 'kildong@email', 2000);

insert into emp (emp_no, emp_name, emp_phone, email, salary)
values(emp_seq.nextval, 'kildongPark', '01-3333-5678', 'pkildong@email', 2300);

select *
from emp
order by emp_no;

update emp
set salary = salary + 500
    ,emp_phone = '01-1111-1111'
where emp_name = 'kildonghong';

delete from emp
where emp_no = 2;


create table member (
mem_no       number        primary key,
mem_name   varchar2(40)  not null,
mem_phone  varchar2(13)  not null,
mem_birth    date default   sysdate,
mem_gen     varchar2(4)    not null
);

create sequence mem_swim;
insert into member (mem_no, mem_name, mem_phone, mem_gen)
values(mem_swim.nextval, 'honggildong', '010-0000-0000', 'men');



