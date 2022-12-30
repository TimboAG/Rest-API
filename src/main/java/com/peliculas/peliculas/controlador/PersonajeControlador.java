package com.peliculas.peliculas.controlador;

import com.peliculas.peliculas.entidad.Personaje;
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
@RequestMapping("/personaje")
@CrossOrigin("*")
public class PersonajeControlador {

    @Autowired
    private PersonajeServicio personajeServicio;

    @GetMapping("/custom")
    public List<Personaje> findAllCustom() {
        return personajeServicio.findAllCustom();
    }

    @GetMapping
    public List<Personaje> findAll() {
        return personajeServicio.listar();
    }

    @GetMapping("/{id}")
    public Optional<Personaje> findById(@PathVariable Long id) {
        return personajeServicio.finById(id);
    }

    @PostMapping
    public Personaje crear(@RequestBody Personaje miPersonaje) {
        return personajeServicio.crear(miPersonaje);
    }

    @PutMapping("/{id}")
    public Personaje actualizar(@PathVariable Long id, @RequestBody Personaje miPersonaje) {
        miPersonaje.setId(id);
        return personajeServicio.actualizar(miPersonaje);
    }

    @DeleteMapping("/{id}")
    public Personaje eliminar(@PathVariable Long id) throws Exception {
        return personajeServicio.eliminar(id);
    }

    @PutMapping("/alta/{id}")
    public Personaje alta(@PathVariable Long id) {
        try {
            return personajeServicio.alta(id);
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }

    @PutMapping("/baja/{id}")
    public Personaje baja(@PathVariable Long id) throws Exception {
        try {
            return personajeServicio.baja(id);
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }
}
