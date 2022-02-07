package com.coderhouse.desafioTestApi.service;

import com.coderhouse.desafioTestApi.model.Producto;
import com.coderhouse.desafioTestApi.repository.RepositoryProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProductoImp implements ServiceProducto {

    @Autowired
    RepositoryProductos productos;

    @Override
    public List getAllProductos() {
        var listaProductos = new ArrayList<>();
        productos.findAll().forEach(listaProductos::add);
        return listaProductos;
    }

    @Override
    public Producto createProducto(Producto producto) {
        productos.save(producto);
        return producto;
    }

    @Override
    public Producto readProducto(Integer id) {
        return productos.findById(id).get();
    }

    @Override
    public Producto updateProducto(Producto producto, Integer id) {
        producto.setId(id);
        productos.save(producto);
        return producto;
    }

    @Override
    public String deleteProducto(Integer id) {
        productos.deleteById(id);
        return "se borro el producto";
    }

    @Override
    public void clearDB(){
        productos.deleteAll();
    }
}
