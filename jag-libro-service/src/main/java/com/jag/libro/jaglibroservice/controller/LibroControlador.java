package com.jag.libro.jaglibroservice.controller;

import com.jag.libro.jaglibroservice.entity.Libro;
import com.jag.libro.jaglibroservice.service.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroServicio kr;

    // Obtener todas los Libros
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = kr.Listar();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // Obtener un Libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id) {
        Optional<Libro> libro = kr.Buscar(id);
        return libro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo Libro
    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = kr.Guardar(libro);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    // Actualizar o modificar un Libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Libro> modificarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Libro libroModificado = kr.Modificar(id, libro);
        return libroModificado != null ? new ResponseEntity<>(libroModificado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar un Libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Libro> eliminarLibro(@PathVariable Long id) {
        kr.Eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
