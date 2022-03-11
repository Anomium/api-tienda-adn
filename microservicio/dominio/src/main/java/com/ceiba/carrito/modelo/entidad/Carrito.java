package com.ceiba.carrito.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Carrito {

    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto.";
    public static final String SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO = "Se debe ingresar el cantidad del producto.";
    public static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto.";
    public static final String SE_DEBE_INGRESAR_EL_FECHA_DEL_PRODUCTO = "Se debe ingresar la fecha de creacion del producto.";
    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente.";
    public static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificacion.";

    private String nombre;
    private Integer cantidad;
    private Double precioProducto;
    private Double precioTotal;
    private LocalDate fecha;
    private String nombreCliente;
    private String identificacion;
    private String cupon;
    private String estadoCompra;

    public Carrito(String nombre, Integer cantidad, Double precioProducto, Double precioTotal, LocalDate fecha,
                   String nombreCliente, String identificacion, String cupon, String estadoCompra) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO);
        validarObligatorio(precioProducto, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(fecha, SE_DEBE_INGRESAR_EL_FECHA_DEL_PRODUCTO);
        validarObligatorio(nombreCliente, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);

        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.identificacion = identificacion;
        this.cupon = cupon;
        this.estadoCompra = estadoCompra;
    }

}
