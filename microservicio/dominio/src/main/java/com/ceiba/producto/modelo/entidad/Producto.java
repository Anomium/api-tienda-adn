package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Producto {

    public static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto.";
    public static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto.";
    public static final String SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO = "Se debe ingresar el cantidad del producto.";
    public static final String SE_DEBE_INGRESAR_EL_FECHA_DEL_PRODUCTO = "Se debe ingresar la fecha de creacion del producto.";
    public static final String SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO = "Se debe ingresar la longitud minima de uno(1).";
    public static final int LONGITUD_MINIMA = 1;
    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private LocalDate fechaCreacion;

    public Producto(Long id, String nombre, Double precio, Integer cantidad, LocalDate fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_EL_CANTIDAD_DEL_PRODUCTO);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_EL_FECHA_DEL_PRODUCTO);
        validarPositivo(cantidad.doubleValue(), SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO);
        validarPositivo(precio, SE_DEBE_INGRESAR_LONGITUD_MINIMA_DE_UNO);
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fechaCreacion = fechaCreacion;
    }
}
