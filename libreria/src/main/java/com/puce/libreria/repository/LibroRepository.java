package com.puce.libreria.repository;

import com.puce.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTitleContainingIgnoreCase(String titulo);
}
