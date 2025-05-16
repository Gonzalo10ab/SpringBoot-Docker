// Este archivo forma parte del paquete com.example.demo
package com.example.demo;

// Importamos la clase CrudRepository que nos da acceso a métodos para trabajar con la base de datos
import org.springframework.data.repository.CrudRepository;

/**
 * Esta interfaz se encarga de acceder a los datos de la tabla "producto".
 * Al extender CrudRepository, hereda automáticamente los métodos más comunes para trabajar con una base de datos.
 *
 * <Producto, Long> indica:
 * - Producto: el tipo de entidad que vamos a manejar (es decir, la clase Producto.java).
 * - Long: el tipo de dato de la clave primaria (el campo id de Producto).
 */
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    // No hace falta escribir ningún método aquí.
    // Spring Boot ya te proporciona automáticamente métodos como:
    // - findAll()        → listar todos los productos
    // - findById(id)     → buscar un producto por ID
    // - save(producto)   → insertar o actualizar un producto
    // - deleteById(id)   → eliminar un producto por ID

}
