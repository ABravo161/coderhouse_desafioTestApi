package com.coderhouse.desafioMySQL.service;

import com.coderhouse.desafioMySQL.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServiceProducto {
    List getAllProductos();
    Producto createProducto(Producto producto);
    Producto readProducto(Integer id);
    Producto updateProducto(Producto producto, Integer id);
    String deleteProducto(Integer id);

}
