package com.jid.service;

import com.jid.daos.UsuarioRepository;
import com.jid.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by igor on 28/11/15.
 */
@Service
public class SessionService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioLogado() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return usuarioRepository.findByEmail(auth.getName());
    }
}
