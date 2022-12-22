package com.peliculas.peliculas.repositorio;

import com.peliculas.peliculas.entidad.Personaje;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepositorio extends JpaRepository<Personaje, Long> {

    @Query("SELECT p FROM Personaje p WHERE eliminado = 'FALSE'")
    public List<Personaje> findAllCustom();

    public Optional<Personaje> findById(Long id);

    @Query("SELECT p FROM Personaje p WHERE nombre = :nombre ")
    List<Personaje> findByName(String nombre);

    @Query("SELECT p FROM Personaje p WHERE edad = :edad ")
    List<Personaje> findByAge(Double edad);

    @Query("SELECT p FROM Personaje p WHERE pelicula_id = :id ")
    List<Personaje> findByMoviesId(Long id);
    
      @Query("SELECT p FROM Personaje p WHERE p.id = :id ")
    List<Personaje> findByUnPersonaje(Long id);
}
