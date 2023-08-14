create database taskmaster;

create table user
(
uname varchar(30),
pass varchar(30)
);

create table task
    (id int not NULL Auto_increment,
     t_name varchar(50)not null,
     due_date date not null,
     tadded_date date default(CURRENT_DATE),
     status varchar(30) default "Not Completed ",
     priority int,
     primary key(id)
    );
