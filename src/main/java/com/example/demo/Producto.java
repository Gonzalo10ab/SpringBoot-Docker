// Declaramos que esta clase pertenece al paquete com.example.demo
package com.example.demo;

// Importamos las anotaciones necesarias para que esta clase funcione como entidad de base de datos
import jakarta.persistence.Entity; // Marca la clase como una entidad JPA (una tabla)
import jakarta.persistence.GeneratedValue; // Controla cómo se genera el ID automáticamente
import jakarta.persistence.GenerationType; // Tipo de estrategia de autogeneración del ID
import jakarta.persistence.Id; // Marca el campo que será la clave primaria (PK)

// Esta anotación indica que esta clase se mapeará a una tabla en la base de datos
@Entity
public class Producto {

    // Este campo será la clave primaria de la tabla
    @Id
    // Generación automática del valor del ID al insertar un nuevo producto
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único de cada producto (clave primaria)

    // Campo para almacenar el nombre del producto
    private String nombre;

    // Campo para almacenar el precio del producto
    private double precio;

    // ================================
    // ========== GETTERS =============
    // Métodos que nos permiten leer los valores de los atributos privados
    // ================================

    // Devuelve el ID del producto
    public Long getId() {
        return id;
    }

    // ================================
    // ========== SETTERS =============
    // Métodos que nos permiten modificar los valores de los atributos privados
    // ================================

    // Asigna un valor al ID del producto
    public void setId(Long id) {
        this.id = id;
    }

    // Devuelve el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Asigna un valor al nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Asigna un valor al precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
