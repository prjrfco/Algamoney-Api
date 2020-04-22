--liquibase formatted sql

--changeset bob:1

create table pessoa
(
	codigo bigserial,
	nome varchar (30),
	logradouro varchar(20),
	numero varchar(5),
	bairro varchar(20),
	cep varchar(8),
	cidade varchar(20),
	estado varchar(20),
	ativo bool,
    primary key (codigo)
);

insert into pessoa values (default , 'Francisco', 'Agapito Pereira', '13', 'Petropolis', '69067372', 'Manaus', 'Amazonas', true);
insert into pessoa values (default , 'Vitor', 'Deus sabe', '20', 'São Jorge', '69089462', 'Joinville', 'Santa Catarina', false);
insert into pessoa values (default , 'Kennedy', 'Betânia', '14', 'Morro da Liberdade', '65067872', 'Belo Horizonte', 'Minas Gerais', true);
insert into pessoa values (default , 'Ricardo', 'Djalma Batista', '08', 'Flores', '61067951', 'Macaé', 'Rio de Janeiro', false);
insert into pessoa values (default , 'Valter', 'Tefé', '06', 'Japiim', '67562764', 'Natal', 'Rio Grande do Norte', true);
insert into pessoa values (default , 'Maria', 'Benjamin Constant', '08', 'Cidade Nova', '69009159', 'Ouro Preto', 'MG', true);
insert into pessoa values (default , 'Abilio', 'Niger', '15', 'São Jorge', '69089462', 'Joinville', 'Santa Catarina', false);
insert into pessoa values (default , 'Oswald', 'Victoria Street', '46', 'Times Square', '79082656', 'Santa Barbara', 'California', true);
insert into pessoa values (default , 'Carrilo', 'Coast Village', '1070', 'San Juan', '61067951', 'Montecito', 'California', false);
insert into pessoa values (default , 'Janiele', '18', '05', 'Monte Sinai', '69000000', 'Manaus', 'Amazonas', true);
insert into pessoa values (default , 'Doom Slayer', 'Agapito Pereira', '13', 'Petropolis', '69067372', 'Manaus', 'Amazonas', true);
insert into pessoa values (default , 'Cebolinha', '17', '14', 'Nova Cidade', '69045753', 'Manaus', 'Amazonas', true);
insert into pessoa values (default , 'Sônia', 'Granada', '08', 'Castelo', '69078258', 'Manaus', 'Amazonas', false);
insert into pessoa values (default , 'Hayden', 'Av Nilton Lins', '06', 'Flores', '69082759', 'Manaus', 'Amazonas', true);