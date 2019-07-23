create database REST_API_DB;
use REST_API_DB;
show tables;
create table user(uid int primary key auto_increment,uname varchar(100),uoccup varchar(100));
insert into user values(1,"user-1","occupation-1");
select * from user;



