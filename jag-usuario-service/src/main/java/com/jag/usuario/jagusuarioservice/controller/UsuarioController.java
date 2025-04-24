package com.jag.usuario.jagusuarioservice.controller;

import com.jag.usuario.jagusuarioservice.entity.Usuario;
import com.jag.usuario.jagusuarioservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listar();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscar(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardar(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // Modificar usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioModificado = usuarioService.modificar(id, usuario);
        return usuarioModificado != null ? new ResponseEntity<>(usuarioModificado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
