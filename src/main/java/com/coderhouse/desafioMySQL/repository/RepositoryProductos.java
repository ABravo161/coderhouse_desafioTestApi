package com.coderhouse.desafioMySQL.repository;

import com.coderhouse.desafioMySQL.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryProductos extends CrudRepository<Producto, Integer> {

}
