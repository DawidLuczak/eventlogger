drop table if exists users;
create table users(
    id int primary key auto_increment,
    name varchar (20) not null,
    description varchar (100)
)
