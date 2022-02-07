package com.coderhouse.desafioTestApi.controller;

import com.coderhouse.desafioTestApi.model.Producto;
import com.coderhouse.desafioTestApi.service.ServiceProducto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class itemsController {

    private final ServiceProducto serviceProducto;


    @GetMapping("/all")
    public List getAllProductos(){
        return serviceProducto.getAllProductos();
    }

    @PostMapping()
    public Producto createProducto(@RequestBody Producto producto){
        return serviceProducto.createProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto readProducto(@PathVariable Integer id){
        return serviceProducto.readProducto(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Integer id){
        return serviceProducto.deleteProducto(id);
    }

}
