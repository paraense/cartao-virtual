package com.jid.daos;

import com.jid.models.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 28/11/15.
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);
}
