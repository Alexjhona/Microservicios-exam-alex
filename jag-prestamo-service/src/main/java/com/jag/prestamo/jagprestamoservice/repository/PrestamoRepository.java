package com.jag.prestamo.jagprestamoservice.repository;

import com.jag.prestamo.jagprestamoservice.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuarioIdAndDevueltoFalse(Long usuarioId);
}
