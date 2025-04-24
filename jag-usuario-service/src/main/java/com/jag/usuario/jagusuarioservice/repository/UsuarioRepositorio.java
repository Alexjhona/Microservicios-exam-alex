package com.jag.usuario.jagusuarioservice.repository;

import com.jag.usuario.jagusuarioservice.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
