package com.ceiba.configuracion;

import com.ceiba.carrito.puerto.repositorio.RepositorioCarrito;
import com.ceiba.carrito.servicio.ServicioActualizarCarrito;
import com.ceiba.carrito.servicio.ServicioCrearCarrito;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import com.ceiba.producto.servicio.ServicioRegistrarProducto;
import com.ceiba.soporte.puerto.repositorio.RepositorioSoporte;
import com.ceiba.soporte.servicio.ServicioActualizarSoporte;
import com.ceiba.soporte.servicio.ServicioCrearSoporte;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioRegistrarProducto servicioRegistrarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioRegistrarProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioCrearCarrito servicioCrearCarrito(RepositorioCarrito repositorioCarrito) {
        return new ServicioCrearCarrito(repositorioCarrito);
    }

    @Bean
    public ServicioActualizarCarrito servicioActualizarCarrito(RepositorioCarrito repositorioCarrito) {
        return new ServicioActualizarCarrito(repositorioCarrito);
    }

    @Bean
    public ServicioActualizarSoporte servicioActualizarSoporte(RepositorioSoporte repositorioSoporte) {
        return new ServicioActualizarSoporte(repositorioSoporte);
    }

    @Bean
    public ServicioCrearSoporte servicioCrearSoporte(RepositorioSoporte repositorioSoporte) {
        return new ServicioCrearSoporte(repositorioSoporte);
    }

}
