// Declaramos que esta clase pertenece al paquete com.example.demo
package com.example.demo;

// Importamos las anotaciones necesarias para hacer peticiones REST y gestionar dependencias
import org.springframework.beans.factory.annotation.Autowired; // Para inyectar automáticamente dependencias
import org.springframework.web.bind.annotation.*; // Importa varias anotaciones REST como @GetMapping, @PostMapping, etc.

import java.util.List; // Para manejar listas de productos
import java.util.stream.Collectors; // Para convertir datos en listas fácilmente
import java.util.stream.StreamSupport; // Para trabajar con los datos devueltos por el repositorio

// Esta clase será un controlador REST: responde a peticiones HTTP (GET, POST, DELETE, etc.)
@RestController

// Prefijo común para todas las rutas de esta clase: todas empiezan por /api/productos
@RequestMapping("/api/productos")

// Permite que este controlador se pueda usar desde cualquier origen (útil para conectar con el frontend)
@CrossOrigin
public class ProductoController {

    // Inyectamos automáticamente el repositorio de productos (Spring lo crea por nosotros)
    @Autowired
    private ProductoRepository productoRepository;

    // ==============================
    // ========== GET ===============
    // ==============================

    // Este método se ejecuta al hacer una petición GET a /api/productos
    // Devuelve una lista de todos los productos existentes
    @GetMapping
    public List<Producto> listarProductos() {
        // findAll() devuelve un iterable → lo convertimos en lista usando StreamSupport
        return StreamSupport.stream(productoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // ==============================
    // ========== POST ==============
    // ==============================

    // Este método se ejecuta al hacer una petición POST a /api/productos
    // Crea un nuevo producto en la base de datos a partir del JSON recibido en el cuerpo de la petición
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto); // Guarda el producto en MySQL
    }

    // ==============================
    // ========== DELETE ============
    // ==============================

    // Este método se ejecuta al hacer DELETE a /api/productos/{id}
    // Elimina el producto con el ID indicado en la URL
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id); // Busca por ID y lo elimina
    }

    // ==============================
    // ========== PUT ===============
    // ==============================

    // Este método se ejecuta al hacer PUT a /api/productos/{id}
    // Actualiza el producto con el ID dado, usando los datos enviados en el cuerpo de la petición
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        // Buscamos el producto existente. Si existe, lo actualizamos. Si no, lanzamos error.
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre()); // Cambia el nombre
            producto.setPrecio(productoActualizado.getPrecio()); // Cambia el precio
            return productoRepository.save(producto); // Guarda los cambios
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}
