package com.jag.prestamo.jagprestamoservice.service.impl;

import com.jag.prestamo.jagprestamoservice.entity.Prestamo;
import com.jag.prestamo.jagprestamoservice.repository.PrestamoRepository;
import com.jag.prestamo.jagprestamoservice.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    private PrestamoRepository repositorio;

    @Override
    public List<Prestamo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Prestamo> buscar(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        prestamo.setDevuelto(false); // Asume que al guardar, aún no se devuelve
        return repositorio.save(prestamo);
    }

    @Override
    public Prestamo modificar(Long id, Prestamo prestamo) {
        prestamo.setId(id);
        return repositorio.save(prestamo);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
