
drop table  if exists 'users';

create table 'users'(
'id' bigint primary key auto_increment,
'userName' varchar(255) not null,
'passWord' varchar(100) not null,
'user_sex' enum('Man','WOMAN'),
'nick_name' varchar(255);
)ENGINE = InnoDB;