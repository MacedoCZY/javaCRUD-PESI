create database dnote;
use dnote;
create table Prod(
	id int not null auto_increment primary key,
    descri varchar(500),
    NCM varchar(9),
    ICMS int,
    preco double,
    empac int,
    codBar varchar(50),
    ativo bool)
    