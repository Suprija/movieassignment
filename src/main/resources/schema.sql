drop table if exists user;
drop table if exists info;
drop table if exists profile;


create table user (id integer AUTO_INCREMENT, username varchar(255),password varchar(255),primary key (id));
create table info (id integer AUTO_INCREMENT,loc varchar(255),lang varchar(255),theatre varchar(255),movie varchar(255),tickets integer,primary key (id));
create table profile (id integer AUTO_INCREMENT,dates date,lang varchar(255),loc varchar(255),movie varchar(255),tickets integer,uname varchar(255),primary key (id));

