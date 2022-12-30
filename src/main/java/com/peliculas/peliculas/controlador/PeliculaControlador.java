package com.peliculas.peliculas.controlador;

import com.peliculas.peliculas.entidad.Genero;
import com.peliculas.peliculas.entidad.Pelicula;
import com.peliculas.peliculas.entidad.Personaje;
import com.peliculas.peliculas.excepciones.MiException;
import com.peliculas.peliculas.servicio.GeneroServicio;
import com.peliculas.peliculas.servicio.PeliculaServicio;
import com.peliculas.peliculas.servicio.PersonajeServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pelicula")
@CrossOrigin("*")

public class PeliculaControlador {

    @Autowired
    private PeliculaServicio peliculaServicio;

    @Autowired
    private GeneroServicio generoServicio;

    @Autowired
    private PersonajeServicio personajeServicio;

    @GetMapping("/custom")
    public List<Pelicula> findAllCustom() {
        return peliculaServicio.findAllCustom();
    }

    @GetMapping
    public List<Pelicula> findAll() {
        return peliculaServicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> findById(@PathVariable Long id) {
        return peliculaServicio.findById(id);
    }

//    @PostMapping
//    public Pelicula crear(@RequestBody Pelicula miPelicula, @RequestBody Long idGenero, @RequestBody Long idPersonaje) {
//        Optional<Genero> miOpGenero = generoServicio.findById(idGenero);
//        Optional<Personaje> miOpPersonaje = personajeServicio.finById(idPersonaje);
//
//        if (miOpGenero.isPresent() && miOpPersonaje.isPresent() ) {
//         peliculaServicio.agregar(miPelicula, idGenero, idPersonaje);
//        }
//        return null;
//    }
//    @PostMapping("/{idG}/{idP}")
//    public Pelicula crear(@RequestBody Pelicula miPelicula, @PathVariable Long idG, @PathVariable Long idP) throws MiException {
//        return peliculaServicio.agregar(miPelicula, idG, idP);
//    }
    @PostMapping
    public Pelicula crear(@RequestBody Pelicula miPelicula) throws MiException {
        return peliculaServicio.agregar(miPelicula);
    }

    
    
    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id, @RequestBody Pelicula miPelicula) {
        miPelicula.setId(id);
        return peliculaServicio.actualizar(miPelicula);
    }

    @DeleteMapping("/{id}")
    public Pelicula eliminar(@PathVariable Long id) throws Exception {
        return peliculaServicio.eliminar(id);
    }

    @PutMapping("/alta/{id}")
    public Pelicula alta(@PathVariable Long id) {
        try {
            return peliculaServicio.alta(id);
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }

    @PutMapping("/baja/{id}")
    public Pelicula baja(@PathVariable Long id) throws Exception {
        try {
            return peliculaServicio.baja(id);
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }
}
