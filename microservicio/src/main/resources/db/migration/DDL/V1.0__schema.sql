create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime not null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 precio numeric not null,
 cantidad integer not null,
 fecha_creacion date not null,
 primary key (id)
);

create table carrito (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 cantidad integer not null,
 precio_producto numeric not null,
 precio_total numeric not null,
 fecha date not null,
 nombre_cliente varchar(100) not null,
 identificacion varchar(100) not null,
 primary key (id),
 constraint fk_nombre foreign key(nombre) references producto(nombre)
);