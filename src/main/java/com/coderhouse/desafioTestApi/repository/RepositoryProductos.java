package com.coderhouse.desafioTestApi.repository;

import com.coderhouse.desafioTestApi.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryProductos extends CrudRepository<Producto, Integer> {

}
