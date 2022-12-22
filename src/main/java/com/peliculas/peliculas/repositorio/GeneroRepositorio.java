package com.peliculas.peliculas.repositorio;

import com.peliculas.peliculas.entidad.Genero;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Long> {

    @Query("SELECT g FROM Genero g WHERE g.eliminado ='FALSE' ")
    public List<Genero> findAllCustom();

    @Query("SELECT g FROM Genero g WHERE g.id =:id ")
    public Genero unGeneroId(Long id);

    @Query("SELECT g FROM Genero g WHERE g.id =:id ")
    public List<Genero> findByIdUnGenero(Long id);
}
