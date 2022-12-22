package com.peliculas.peliculas.servicio;

import com.peliculas.peliculas.entidad.Genero;
import com.peliculas.peliculas.entidad.Pelicula;
import com.peliculas.peliculas.entidad.Personaje;
import com.peliculas.peliculas.excepciones.MiException;
import com.peliculas.peliculas.repositorio.GeneroRepositorio;
import com.peliculas.peliculas.repositorio.PeliculaRepositorio;
import com.peliculas.peliculas.repositorio.PersonajeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaServicio {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;
     @Autowired
    private GeneroRepositorio generoRepositorio;

     @Autowired
    private PersonajeRepositorio personajeRepositorio; 
     
    @Transactional
    public List<Pelicula> findAllCustom() {
        return peliculaRepositorio.findAllCustom();
    }

    @Transactional
    public List<Pelicula> listar() {
        return peliculaRepositorio.findAll();
    }

    @Transactional
    public Optional<Pelicula> findById(Long id) {
        return peliculaRepositorio.findById(id);
    }
    
//        @Transactional
//    public Pelicula agregar(Pelicula miPelicula, Long idGenero, Long idPersonaje) {
//        List<Genero> miListGenero = generoRepositorio.findByIdUnGenero(idGenero);
//        List<Personaje> miListPersonaje = personajeRepositorio.findByUnPersonaje(idPersonaje);
//        miPelicula.setPeliGenero(miListGenero);
//        miPelicula.setPersonajePelicula(miListPersonaje);
//        return peliculaRepositorio.save(miPelicula);
//    }

    @Transactional
    public Pelicula agregar(Pelicula miPelicula) {
        return peliculaRepositorio.save(miPelicula);
    }

    @Transactional
    public Pelicula actualizar(Pelicula miPelicula) {
        Pelicula miObjPeli = peliculaRepositorio.getById(miPelicula.getId());
        BeanUtils.copyProperties(miPelicula, miObjPeli);
        return peliculaRepositorio.save(miObjPeli);
    }

    @Transactional
    public Pelicula eliminar(Long id) throws MiException {
        Optional<Pelicula> miOptional = peliculaRepositorio.findById(id);
        try {
            if (miOptional.isPresent()) {
                peliculaRepositorio.deleteById(id);
            }
        } catch (Exception e) {
            throw new MiException("Error al eliminar, verifique si el elemnto ");
        }
        return null;
    }

    @Transactional
    public Pelicula alta(Long id) throws MiException {
        Optional<Pelicula> miOptional = peliculaRepositorio.findById(id);
        try {
            if (miOptional.isPresent()) {
                Pelicula miObjPeli = miOptional.get();
                miObjPeli.setEliminado(false);
            }
        } catch (Exception e) {
            throw new MiException("Error al dar de alta, verifique si el elemnto ");
        }
        return null;
    }

    @Transactional
    public Pelicula baja(Long id) throws MiException {
        Optional<Pelicula> miOptional = peliculaRepositorio.findById(id);
        try {
            if (miOptional.isPresent()) {
                Pelicula miObjPeli = miOptional.get();
                miObjPeli.setEliminado(true);
            }
        } catch (Exception e) {
            throw new MiException("Error al dar de baja, verifique si el elemnto ");
        }
        return null;
    }
}
