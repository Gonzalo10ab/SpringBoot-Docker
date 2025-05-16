// Declaramos el paquete al que pertenece esta clase
package com.example.demo;

// Importamos las anotaciones necesarias para que esta clase se comporte como una entidad de base de datos
import jakarta.persistence.Entity;              // Marca la clase como una entidad JPA (una tabla)
import jakarta.persistence.GeneratedValue;     // Indica que el campo se generará automáticamente
import jakarta.persistence.GenerationType;     // Especifica el tipo de generación del ID
import jakarta.persistence.Id;                 // Marca qué campo será la clave primaria (Primary Key)

// Esta anotación le dice a Spring que esta clase representa una tabla en la base de datos
@Entity
public class Usuario {

    // Este campo será la clave primaria de la tabla "usuario"
    @Id
    // Este campo se autogenerará cuando se inserte un nuevo usuario (tipo autoincrement)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único del usuario

    // Campo que almacena el nombre del usuario
    private String nombre;

    // Campo que almacena la edad del usuario
    private int edad;

    // =====================================
    // ======== GETTERS y SETTERS =========
    // Estos métodos permiten acceder y modificar los campos privados desde fuera de la clase
    // Son fundamentales para que JPA (y otros frameworks) puedan leer y escribir datos
    // =====================================

    /**
     * Devuelve el valor del campo "id"
     * @return el ID del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna un nuevo valor al campo "id"
     * @param id el nuevo ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del usuario
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre al usuario
     * @param nombre el nuevo nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la edad del usuario
     * @return la edad del usuario
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Asigna una nueva edad al usuario
     * @param edad la nueva edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
