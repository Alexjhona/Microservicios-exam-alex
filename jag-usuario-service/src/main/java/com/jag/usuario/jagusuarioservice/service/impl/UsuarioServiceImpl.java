package com.jag.usuario.jagusuarioservice.service.impl;

import com.jag.usuario.jagusuarioservice.entity.Usuario;
import com.jag.usuario.jagusuarioservice.repository.UsuarioRepositorio; // Nombre original
import com.jag.usuario.jagusuarioservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio; // Coincide con el nombre del repositorio

    @Override
    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> buscar(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario modificar(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
