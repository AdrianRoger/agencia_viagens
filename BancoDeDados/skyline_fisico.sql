drop database skyline;
create database skyline;
use skyline;

create table if not exists CLIENTES(
	cpf varchar(11) primary key,
    nome varchar(50) not null,
    email varchar(30) unique not null,
    telefone varchar(14),
    cep varchar(8) not null,
    rua varchar(50) not null,
    numero int not null,
    complemento varchar(50),
    ativo boolean default true
);

create table if not exists CIDADES(
	id_cidade int primary key auto_increment,
    cidade varchar(30) not null,
    estado varchar(30) not null,
    pais varchar(30) not null,
    aeroporto varchar(50) not null
);

create table if not exists VOO(
	id_voo int primary key auto_increment,
    num_voo int unique not null,
    comp_aerea varchar(30) not null,
    assentos int not null,
    preco_unit decimal(10,2) not null,
    data_partida date not null,
    FK_id_cidade_origem int not null,
    FK_id_cidade_destino int not null,
    constraint foreign key (FK_id_cidade_origem) references cidades(id_cidade),
    constraint foreign key (FK_id_cidade_destino) references cidades(id_cidade)
);

create table if not exists RESERVAS(
	id_reserva int primary key auto_increment,
    data_reserva date not null,
    num_pessoas int not null,
    cancelada boolean default false,
    FK_cpf_clientes varchar(11) not null,
    FK_id_voo int not null,
    constraint foreign key (FK_cpf_clientes) references clientes(cpf),
    constraint foreign key (FK_id_voo) references voo(id_voo)
);

create table if not exists CONTATO(
	id_contato int primary key auto_increment,
    nome varchar(50) not null,
    email varchar(30) not null,
    telefone varchar(14) not null,
    mensagem varchar(500) not null,
    resolvido boolean default false
);

