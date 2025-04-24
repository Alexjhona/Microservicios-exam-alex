package com.jag.libro.jaglibroservice.repository;

import com.jag.libro.jaglibroservice.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
}
