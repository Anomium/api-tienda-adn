package com.ceiba.carrito.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

@Getter
@Setter
public class Carrito {

    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto.";
    public static final String SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO = "Se debe ingresar el cantidad del producto.";
    public static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto.";
    public static final String SE_DEBE_INGRESAR_VALOR_POSITIVO = "Se debe de ingresar un valor positivo.";

    private Long id;
    private String nombre;
    private Integer cantidad;
    private Double precioProducto;
    private Double precioTotal;
    private LocalDate fecha;
    private String cupon;
    private String estadoCompra;

    public Carrito(Long id, String nombre, Integer cantidad, Double precioProducto, Double precioTotal, LocalDate fecha,
                   String cupon, String estadoCompra) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(precioProducto, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO);
        validarPositivo(cantidad.doubleValue(), SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarPositivo(precioProducto, SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarPositivo(precioTotal, SE_DEBE_INGRESAR_VALOR_POSITIVO);

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
        this.cupon = cupon;
        this.estadoCompra = estadoCompra;
    }

}
