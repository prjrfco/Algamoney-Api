--liquibase formatted sql

--changeset bob:1

create table usuario
(
    codigo bigserial,
    nome VARCHAR (50) NOT NULL,
    email VARCHAR (50) NOT NULL,
    senha VARCHAR (150) NOT NULL,
    primary key (codigo)
);


INSERT INTO usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$I36iqpNMl2HFKr2eEvDn2OgQFKy6jGl6ocuGzwPsz2DFXodoLd54e');--admin
INSERT INTO usuario (codigo, nome, email, senha) values (2, 'francisco', 'francisco@algamoney.com', '$2a$10$hCz4KZ2lRrEX24wsOKs43e6qmOioUqzkvCwwFCBU0zQvvJu/vbSGe');--francisco