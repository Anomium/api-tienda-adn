create table usuario (
 id int(100) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime not null,
 primary key (id)
);

create table producto (
 id int(100) not null auto_increment,
 nombre varchar(100) not null,
 precio numeric not null,
 cantidad integer not null,
 fecha_creacion date not null,
 primary key (id)
);

create table carrito (
 id int(100) not null auto_increment,
 nombre varchar(100) not null,
 cantidad integer not null,
 precio_producto numeric not null,
 precio_total numeric not null,
 fecha date not null,
 nombre_cliente varchar(100) not null,
 identificacion varchar(100) not null,
 cupon varchar(50),
 estado_compra varchar(10),
 primary key (id)
);

create table cupones(
    id varchar(100) not null,
    nombre varchar(100) not null,
    fecha_utilizacion date,
    utilizado boolean,
    primary key (id)
);

create table soporte(
    id int(100) not null auto_increment,
    descripcion_soporte varchar(100) not null,
    fecha_creacion date,
    fecha_a_solucionar date,
    estado varchar(50),
    primary key (id)
);

insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('f1c053a5-cada-4511-a0c2-79d4d21de880', '7ba7a5bd-ec38-4e62-90d2-b79380be3852', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('d3feaaec-4c0f-4a00-a08a-510634990c5c', '6e58767a-0dfc-464c-987b-3f99074483a8', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('5c79b37a-c81a-454e-941d-9031efb1243f', 'ff6bbb2d-a41a-47f5-a967-500c7e0ee187', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('64c73478-d6a6-49e6-b72f-01bba5b25cb6', '4dbfafd6-41e5-48ab-b488-ca38a88965a6', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('657a3369-9d59-4043-a205-33d6f30730f6', '4559118e-6c58-4949-850c-47360f0f8b52', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('03131a6a-9f3b-4dbd-92d9-4c565d334db0', '22940146-c935-4f60-9d86-ee03a722d745', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('82c8313c-a3e9-496c-b91c-e5d1122c042e', '89deda5f-c7ce-4848-ae17-706f796b4df8', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('81a62b33-8a56-43ee-9ddd-39e925b5d4ce', '7d142242-64cc-4ff7-91df-67cbc3af5abc', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('bcfdb8a5-b27c-4edd-94e6-46378240df05', '31f7658c-6a26-42a2-bf3c-820f07857c5d', null, false);
insert into cupones (id, nombre, fecha_utilizacion, utilizado)
values ('1a32e2ba-03a8-49fc-9a4a-b76fdd72ebb9', '965fa89c-5c56-43d6-bce7-ef40651feeff', null, false);

insert into soporte (descripcion_soporte, fecha_creacion, fecha_a_solucionar, estado)
values ('esto es una prueba', '2022-03-08', '2022-03-08', 'CREADO');