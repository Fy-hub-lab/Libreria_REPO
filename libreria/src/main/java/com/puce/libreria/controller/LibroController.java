package com.puce.libreria.controller;

import com.puce.libreria.entity.Libro;
import com.puce.libreria.servicio.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {

    //Inyeccion de dependencias  ppor campo
    @Autowired
    private LibroService libroService;

    // Mostrar la lista libros
    @GetMapping
    public String mostrarLibros(@RequestParam(name = "inputLibro", required = false, defaultValue = "")String inputLibro, Model model){
        List<Libro> libros = libroService.BuscarLibroTitulo(inputLibro);
        model.addAttribute("inputLibro", inputLibro);
        model.addAttribute("libros", libros);
        return "pages/libroLista";

    }

    @GetMapping("/formulario")
    public String mostrarformulario(){

        return "pages/libroform";
    }


}
