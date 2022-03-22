package com.ceiba.carrito.comando.fabrica;

import com.ceiba.carrito.comando.ComandoCarrito;
import com.ceiba.carrito.modelo.entidad.Carrito;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaCarrito {

    public List<Carrito> crear(List<ComandoCarrito> comandoCarrito) {
        List<Carrito> carritos = new ArrayList<>();

        comandoCarrito.forEach(comCar ->
                carritos.add(new Carrito(
                    comCar.getId(),
                    comCar.getNombre(),
                    comCar.getCantidad(),
                    comCar.getPrecio(),
                    comCar.getPrecioTotal(),
                    comCar.getFecha(),
                    comCar.getCupon(),
                    comCar.getEstadoCompra()
        )));
        return carritos;
    }

    public List<Carrito> crearActualizacion(List<ComandoCarrito> comandoCarrito) {
        List<Carrito> carritos = new ArrayList<>();

        comandoCarrito.forEach(comCar ->
                carritos.add(new Carrito(
                        comCar.getId(),
                        comCar.getCantidad(),
                        comCar.getPrecio()
                )));
        return carritos;
    }

}
