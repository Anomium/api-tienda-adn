package com.ceiba.carrito.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Carrito {

    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto.";
    public static final String SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO = "Se debe ingresar el cantidad del producto.";
    public static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto.";
    public static final String SE_DEBE_INGRESAR_VALOR_POSITIVO = "Se debe de ingresar un valor positivo.";
    public static final String SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO = "Se debe ingresar la longitud minima de uno(1).";
    public static final String SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO = "Se debe ingresar el id del producto.";

    public static final Long LONGITUD_MINIMA = 1L;
    public static final double DESCUENTO_A_PAGAR = 0.9;
    public static final String NO_DEBERIA_DE_EXISTIR_ID = "No deberia de existir id.";
    public static final String SE_DEBE_INGRESAR_LA_FECHA_DEL_PRODUCTO = "Se debe ingresar la fecha del producto.";


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
        validarNoObligatorio(id, NO_DEBERIA_DE_EXISTIR_ID);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(precioProducto, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO);
        validarPositivo(cantidad.doubleValue(), SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarPositivo(precioProducto, SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarPositivo(precioTotal, SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarMenor(LONGITUD_MINIMA, precioTotal.longValue(), SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO);
        validarMenor(LONGITUD_MINIMA, precioProducto.longValue(), SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO);

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
        this.cupon = cupon;
        this.estadoCompra = estadoCompra;
    }

    public Carrito(Long id, Integer cantidad, Double precioProducto, String cupon, LocalDate fecha) {
        validarObligatorio(id, SE_DEBE_INGRESAR_EL_ID_DEL_PRODUCTO);
        validarObligatorio(precioProducto, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO);
        validarPositivo(cantidad.doubleValue(), SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarPositivo(precioProducto, SE_DEBE_INGRESAR_VALOR_POSITIVO);
        validarMenor(LONGITUD_MINIMA, precioProducto.longValue(), SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO);
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA_DEL_PRODUCTO);

        this.id = id;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.cupon = cupon;
        this.fecha = fecha;
    }

    public void precioConDescuento(Double precioProducto, Integer cantidad){
        precioTotal = precioProducto * cantidad * DESCUENTO_A_PAGAR;
    }

    public void precioSinDescuento(Double precioProducto, Integer cantidad) {
        precioTotal = precioProducto * cantidad;
    }

    public void estado(String estado) {
        estadoCompra = estado;
    }

    public void fecha() {
        fecha = LocalDate.now();
    }

}
