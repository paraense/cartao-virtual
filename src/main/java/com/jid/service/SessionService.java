package com.jid.service;

import com.jid.daos.ClienteRepository;
import com.jid.daos.LojaRepository;
import com.jid.daos.UsuarioRepository;
import com.jid.models.Cliente;
import com.jid.models.Loja;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public Usuario getUsuarioLogado() {
        Authentication auth = getAuthentication();

        return usuarioRepository.findByEmail(auth.getName());
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Cliente getClienteLogado() {
        return clienteRepository.findByUsuario(getUsuarioLogado());
    }

    public Loja getLojaLogada() {
        return lojaRepository.findByUsuario(getUsuarioLogado());
    }
}
