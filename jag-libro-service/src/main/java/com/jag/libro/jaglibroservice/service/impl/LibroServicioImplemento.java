package com.jag.libro.jaglibroservice.service.impl;

import com.jag.libro.jaglibroservice.entity.Libro;
import com.jag.libro.jaglibroservice.repository.LibroRepositorio;
import com.jag.libro.jaglibroservice.service.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicioImplemento implements LibroServicio {

    @Autowired
    private LibroRepositorio kr;

    @Override
    public List<Libro> Listar() {
        return kr.findAll();
    }

    @Override
    public Optional<Libro> Buscar(Long id) {
        return kr.findById(id);
    }

    @Override
    public Libro Guardar(Libro libro) {
        return kr.save(libro);
    }

    @Override
    public Libro Modificar(Long id, Libro libro) {
        libro.setId(id);
        return kr.save(libro);
    }

    @Override
    public void Eliminar(Long id) {
        kr.deleteById(id);
    }
}
