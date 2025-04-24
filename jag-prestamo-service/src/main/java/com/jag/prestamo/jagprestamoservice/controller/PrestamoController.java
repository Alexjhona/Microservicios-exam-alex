package com.jag.prestamo.jagprestamoservice.controller;

import com.jag.prestamo.jagprestamoservice.entity.Prestamo;
import com.jag.prestamo.jagprestamoservice.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService servicio;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> buscar(@PathVariable Long id) {
        Optional<Prestamo> prestamo = servicio.buscar(id);
        return prestamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prestamo> guardar(@RequestBody Prestamo prestamo) {
        return new ResponseEntity<>(servicio.guardar(prestamo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> modificar(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(servicio.modificar(id, prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
