package com.coderhouse.desafioTestApi.service;

import com.coderhouse.desafioTestApi.model.Producto;

import java.util.List;


public interface ServiceProducto {
    void clearDB();
    List getAllProductos();
    Producto createProducto(Producto producto);
    Producto readProducto(Integer id);
    Producto updateProducto(Producto producto, Integer id);
    String deleteProducto(Integer id);

}
