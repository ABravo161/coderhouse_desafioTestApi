package com.coderhouse.desafioTestApi;

import com.coderhouse.desafioTestApi.model.Producto;
import com.coderhouse.desafioTestApi.service.ServiceProducto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesafioTestApiApplicationTests {

	@LocalServerPort
	private int port;
	private String url;
	private static long startTime;
	private static long endtTime;

	@Autowired
	private ServiceProducto serviceProducto;
	@Autowired
	private TestRestTemplate restTemplate;


	//IMPRIMO Y CALCULO EL TIEMPO ANTES DE EJECUTAR TODOS LOS TEST
	@BeforeAll
	static void printBefore(){
		startTime = System.nanoTime();
		System.out.println("ejecutando todos los test");
	}

	//IMPRIMO Y CALCULO EL TIEMPO DESPUES DE TERMINAR TODOS LOS TEST
	@AfterAll
	static void printAfterAll(){
		endtTime = System.nanoTime();
		System.out.println("todos los test se ejecutaron con una duracion de: "+ TimeUnit.NANOSECONDS.toMillis(endtTime-startTime) + " ms");
	}

	//AJUSTO LA URL E IMPRIMO ANTES DE CADA TEST
	@BeforeEach
	void init() {
		url = String.format("http://localhost:%d/productos", port);
		System.out.println("se ejecuta un test");
	}

	//LIMPIAMOS LA DB ANTES DE CADA TEST Y AGREGAMOS 4 PRODUCTOS
	@BeforeEach()
	void setProductos() {
		serviceProducto.createProducto(Producto.of(1,"Leche","lacteos",200));
		serviceProducto.createProducto(Producto.of (2, "azucar", "endulzantes", 250));
		serviceProducto.createProducto(Producto.of(3,"pan lactal", "harinas",200));
		serviceProducto.createProducto(Producto.of(4,"te","infusiones",150));
	}

	@AfterEach()
	void cleanDB(){
		serviceProducto.clearDB();
	}


	// TEST POST DE UN PRODUCTO
	@Test
	void postProducto(){
		var uriTest = url;

		var productoNuevo = Producto.builder().id(10).nombre("leche").categoria("lacteos").stock(100).build();
		var result = this.restTemplate.postForObject(uriTest,productoNuevo, Producto.class);

		Assert.isTrue(productoNuevo.equals(result), "los productos son diferentes" + result + productoNuevo);
	}


	//TESTEAMOS EL GET DE TODOS LOS PRODUCTOS
	@Test
	public void getAllProductos() throws Exception {
		var uriTest = String.format("%s%s", url, "/all");

		var messageResult = this.restTemplate.getForObject(uriTest, List.class);

		Assert.notNull(messageResult, "Lista de productos es nula");
		Assert.notEmpty(messageResult, "Lista de productos esta vacia");
		Assert.isTrue(messageResult.size()==4, "el tamaño de la lista es"+messageResult.size());
	}


	//TESTEAMOS EL GET POR ID
	@Test
	public void getById(){
		var uriTest = String.format("%s%s", url, "/1");

		var messageResult = this.restTemplate.getForObject(uriTest, Producto.class);

		Assert.notNull(messageResult, "El producto es NULL");
		Assert.isTrue(messageResult.equals(Producto.of(1,"Leche", "lacteos", 200)), "el producto es "+ messageResult.toString());
	}


	//TESTEAMOS EL DELETE POR ID
	@Test
	public void deleteById() throws Exception {
		var uriTest = String.format("%s%s", url, "/1");
		this.restTemplate.delete(uriTest);

		uriTest = String.format("%s%s", url, "/all");
		var messageResult = this.restTemplate.getForObject(uriTest, List.class);

		Assert.notNull(messageResult, "Lista de productos es nula");
		Assert.notEmpty(messageResult, "Lista de productos esta vacia");
		Assert.isTrue(messageResult.size()==3, "el tamaño de la lista es "+messageResult.size());
	}
}
