package com.ceiba.manejador;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ManejadorComandoList<C> {

    @Transactional
    void ejecutar(List<C> comando);

}
