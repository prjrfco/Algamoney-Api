--liquibase formatted sql

--changeset bob:1

create table usuario_permissao
(
    codigo_usuario bigserial references usuario (codigo) match simple on UPDATE cascade on DELETE cascade,
    codigo_permissao bigserial references permissao (codigo) match simple on UPDATE cascade on DELETE cascade
);

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (1, 8);

-- francisco
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (2, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao)values (2, 8);



