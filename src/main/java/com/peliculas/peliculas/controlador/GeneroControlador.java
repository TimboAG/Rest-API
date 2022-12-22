package com.peliculas.peliculas.controlador;

import com.peliculas.peliculas.entidad.Genero;
import com.peliculas.peliculas.servicio.GeneroServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroControlador {

    @Autowired
    private GeneroServicio servicioGenero;

    @GetMapping("/custom")
    public List<Genero> findAllCustom() {
        return servicioGenero.findAllCustom();
    }

    @GetMapping
    public List<Genero> findAll() {
        return servicioGenero.listar();
    }

    @GetMapping("/{id}")
    public Optional<Genero> findById(@PathVariable Long id) {
        return servicioGenero.findById(id);
    }

    @PostMapping
    public Genero crear(@RequestBody Genero miGenero) {
        return servicioGenero.agregar(miGenero);
    }

    @PutMapping("/{id}")
    public Genero actualizar(@PathVariable Long id, @RequestBody Genero miGenero) {
        miGenero.setId(id);
        return servicioGenero.actualizar(miGenero);
    }

    @DeleteMapping("/{id}")
    public Genero eliminar(@PathVariable Long id) throws Exception {
        return servicioGenero.eliminar(id);
    }

    @PutMapping("/alta/{id}")
    public Genero alta(@PathVariable Long id) {
        try {
            return servicioGenero.alta(id);
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }

    @PutMapping("/baja/{id}")
    public Genero baja(@PathVariable Long id) throws Exception {
        try {
            return servicioGenero.baja(id);
        } catch (Exception e) {
            System.err.println("error");
        }
        return null;
    }
}
