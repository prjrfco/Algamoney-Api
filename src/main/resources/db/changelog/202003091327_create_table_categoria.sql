--liquibase formatted sql

--changeset bob:1
create table categoria
(
	codigo bigserial,
	nome varchar(20) not null,
    primary key (codigo)
);

insert into categoria (nome) values ('Lazer');
insert into categoria (nome) values ('Alimentação');
insert into categoria (nome) values ('Supermercado');
insert into categoria (nome) values ('Farmácia');
insert into categoria (nome) values ('Outros');
