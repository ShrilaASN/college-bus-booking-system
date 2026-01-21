create database BusManagementSystem;

use BusManagementSystem;
create table login(username varchar(20), password varchar(20));
insert into login values('admin', 'admin');

select*from login;

create table coordinator (name varchar(20), department varchar(5), phone varchar(15), address varchar(50), emp_id varchar(20), gender varchar(20));
create table bus(bus_id varchar(10), bus_no varchar(15), driver varchar(20), source varchar(40), destination varchar(40));

describe bus;

insert into bus values("B01", "KA01AB1234", "Ramesh", "ACSCE", "Meta");
insert into bus values("B02", "KA01CD1453", "Suresh", "ACSCE", "Google");
insert into bus values("B03", "KA01EF1112", "Mahesh", "ACSCE", "Microsoft");
insert into bus values("B04", "KA01GH3222", "Sarvesh", "ACSCE", "Infosys");
insert into bus values("B05", "KA01IJ1212", "Devesh", "ACSCE", "Apple");

show tables;
drop table if exists booking;


desc booking;


select * from bus;

create table booking(PNR varchar(15), REF_ID varchar(20), empid varchar(20), name varchar(20), dept varchar(30), busnumber varchar(15), busid varchar(20), src varchar(30), des varchar(30), ddate varchar(30));
create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), bus_id varchar(20), ddate varchar(30));

alter table booking add constraint unique_bus_date unique(busid, ddate);

select * from coordinator;
select * from booking;
select database();
select count(*) from booking;

create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), ddate varchar(30));
