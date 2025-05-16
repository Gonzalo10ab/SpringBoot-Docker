// Indicamos que esta clase pertenece al paquete com.example.demo
package com.example.demo;

// Importamos las herramientas necesarias de Spring
import org.springframework.beans.factory.annotation.Autowired; // Permite inyectar dependencias automáticamente
import org.springframework.web.bind.annotation.*; // Contiene las anotaciones para crear un controlador REST

// Importamos clases de utilidades de Java para trabajar con listas y flujos de datos
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

// Esta anotación indica que esta clase será un controlador REST
// Es decir, responderá a peticiones HTTP como GET, POST, PUT, DELETE, etc.
@RestController

// Establece la ruta base de todas las peticiones de este controlador: /api/usuarios
@RequestMapping("/api/usuarios")

// Permite que este controlador acepte peticiones desde otro origen (por ejemplo, desde el frontend que carga en localhost:8080)
@CrossOrigin
public class UsuarioController {

    // Inyectamos el repositorio de usuarios (UsuarioRepository)
    // Spring Boot lo inicializa automáticamente sin que tengamos que crear un objeto manualmente
    @Autowired
    private UsuarioRepository usuarioRepository;

    // ===========================================
    // =============== GET =======================
    // ===========================================

    // Maneja peticiones GET a /api/usuarios
    // Devuelve una lista completa de todos los usuarios en la base de datos
    @GetMapping
    public List<Usuario> listarUsuarios() {
        // usuarioRepository.findAll() devuelve un Iterable, así que lo convertimos a una List con StreamSupport
        return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // ===========================================
    // =============== POST ======================
    // ===========================================

    // Maneja peticiones POST a /api/usuarios
    // Crea un nuevo usuario en base a los datos que llegan en el cuerpo (body) de la petición
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        // Guardamos el nuevo usuario en la base de datos usando save()
        return usuarioRepository.save(usuario);
    }

    // ===========================================
    // ============== DELETE =====================
    // ===========================================

    // Maneja peticiones DELETE a /api/usuarios/{id}
    // Borra el usuario con el ID especificado en la URL
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        // Usamos el método deleteById para borrar directamente por su ID
        usuarioRepository.deleteById(id);
    }

    // ===========================================
    // =============== PUT =======================
    // ===========================================

    // Maneja peticiones PUT a /api/usuarios/{id}
    // Actualiza los datos del usuario con el ID indicado, usando los nuevos datos recibidos en el cuerpo de la petición
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        // Buscamos si el usuario existe por su ID
        // Si lo encontramos, actualizamos sus datos y lo volvemos a guardar
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre()); // Actualizamos el nombre
            usuario.setEdad(usuarioActualizado.getEdad());     // Actualizamos la edad
            return usuarioRepository.save(usuario);            // Guardamos los cambios en la base de datos
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado")); // Si no existe, lanzamos un error
    }
}
