package com.jid.service;

import com.jid.daos.UsuarioRepository;
import com.jid.models.PermissaoUsuario;
import com.jid.models.Usuario;
import com.jid.util.Sha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

/**
 * Created by igor on 28/11/15.
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastra(Usuario usuario, PermissaoUsuario permissao) throws NoSuchAlgorithmException {
        usuario.setSenha(Sha.hash256(usuario.getSenha()));
        usuario.setPermissao(permissao);

        usuarioRepository.save(usuario);
    }

    public void cadastraCliente(Usuario usuario) throws NoSuchAlgorithmException {
        cadastra(usuario, PermissaoUsuario.CLIENTE);
    }
}
