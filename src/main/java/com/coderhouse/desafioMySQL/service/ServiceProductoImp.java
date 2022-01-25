package com.coderhouse.desafioMySQL.service;

import com.coderhouse.desafioMySQL.model.Producto;
import com.coderhouse.desafioMySQL.repository.RepositoryProductos;
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
        List listaProductos = new ArrayList<>();
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
}
