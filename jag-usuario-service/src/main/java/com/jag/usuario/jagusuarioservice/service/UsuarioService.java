package com.jag.usuario.jagusuarioservice.service;

import com.jag.usuario.jagusuarioservice.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();
    Optional<Usuario> buscar(Long id);
    Usuario guardar(Usuario usuario);
    Usuario modificar(Long id, Usuario usuario);
    void eliminar(Long id);

}
