package com.jag.prestamo.jagprestamoservice.service;

import com.jag.prestamo.jagprestamoservice.entity.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    List<Prestamo> listar();
    Optional<Prestamo> buscar(Long id);
    Prestamo guardar(Prestamo prestamo);
    Prestamo modificar(Long id, Prestamo prestamo);
    void eliminar(Long id);
}
