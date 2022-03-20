update carrito
set estado_compra = :estadoCompra,
    precio_total = :precioTotal
where id = :id and estado_compra = 'PENDIENTE';