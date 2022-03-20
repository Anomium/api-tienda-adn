insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into producto(id, nombre, precio, cantidad, fecha_creacion)
values(1,'Esto es una prueba1',30,6,'2022-03-08');

insert into producto(id, nombre, precio, cantidad, fecha_creacion)
values(2,'Esto es una prueba2',30,6,'2022-03-08');

insert into producto(id, nombre, precio, cantidad, fecha_creacion)
values(3,'Esto es una prueba3',30,6,'2022-03-08');

insert into carrito (id,nombre, cantidad, precio_producto, precio_total, fecha, cupon, estado_compra)
values (1,'Esto es una prueba1', 6, 30, 40, '2022-03-08', null, 'PENDIENTE');

insert into carrito (id, nombre, cantidad, precio_producto, precio_total, fecha, cupon, estado_compra)
values (2,'Esto es una prueba2', 6, 30, 40, '2022-03-08', null, 'PENDIENTE');

insert into soporte (descripcion_soporte, fecha_creacion, fecha_a_solucionar, estado)
values ('esto es una prueba', '2022-03-08', '2022-03-08', 'PENDIENTE');
