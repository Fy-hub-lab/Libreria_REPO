package com.puce.libreria.servicio;

import com.puce.libreria.entity.Libro;
import com.puce.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    //Leer - SELECT
    public List<Libro> leeribros(){
        return libroRepository.findAll();
    }

    //Buscar Libro por ID - SELCT * from libros where ID=100,
    public Optional<Libro> buscarLibroById(Long id){
        return libroRepository.findById(id);

    }

    // Buscar Libro por titulo - SELCT * FROM LIBROS WHERE TITULO = "SPIDERMAN"(TITULO)
    public List<Libro> BuscarLibroTitulo(String inputTitulo){
        if (inputTitulo ==null || inputTitulo.isEmpty()){
            return libroRepository.findAll();

        }else {
            return libroRepository.findByTitleContainingIgnoreCase(inputTitulo);
        }
    }
//Guardar - INSERTE INTO LIBRO VALUES
    public Libro guardarlibro(Libro libro){
        libroRepository.save(libro);
        return libro;
    }

    // Actualizar - UPDATE LIBRO SET TITULO= "BATMAN" WHERE ID=102
    public Libro actualizarLibro(Long id, Libro libro){
        Libro libroExistente = buscarLibroById(id)
                .orElseThrow(()-> new RuntimeException("Libro no existe"));
        libroExistente.setTitle(libro.getTitle());
        libroExistente.setEditorial(libro.getEditorial());
        libroExistente.setGenero(libro.getGenero());
        libroExistente.setNumero_paginas(libro.getNumero_paginas());
        return libroRepository.save(libroExistente);
    }
    // ELIMINAR - DELETE FROM LIBROS WHERE ID = 100;
    public void eliminarLibro(Long id){
        Libro libroEliminar = buscarLibroById(id)
                .orElseThrow(()-> new RuntimeException("Libro no existe"));
        libroRepository.delete(libroEliminar);
    }
}
