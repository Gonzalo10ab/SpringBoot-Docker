// Declaramos que esta clase forma parte del paquete com.example.demo
package com.example.demo;

// Importamos CrudRepository, que nos da acceso a todos los métodos CRUD sin escribir nada más
import org.springframework.data.repository.CrudRepository;

/**
 * Esta interfaz representa el repositorio de usuarios.
 * Es la encargada de comunicarse con la base de datos para realizar operaciones
 * como crear, leer, actualizar y eliminar usuarios.
 *
 * Al extender CrudRepository<Usuario, Long>:
 * - Usuario → es el tipo de entidad con la que trabaja (modelo)
 * - Long    → es el tipo de dato del ID (clave primaria)
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    // No necesitas implementar nada.
    // Spring Boot crea automáticamente todos los métodos básicos de acceso a datos:
    //
    // - findAll()         → obtener todos los usuarios
    // - findById(id)      → buscar un usuario por su ID
    // - save(usuario)     → guardar o actualizar un usuario
    // - deleteById(id)    → eliminar un usuario por su ID
    //
    // Si quisieras añadir búsquedas personalizadas (por nombre, edad...), podrías
    // crear métodos aquí usando la convención de nombres de Spring Data.
    //
    // Ejemplo:
    // List<Usuario> findByNombre(String nombre);
}
