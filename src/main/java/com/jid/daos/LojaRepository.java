package com.jid.daos;

import com.jid.models.Loja;
import com.jid.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by igor on 28/11/15.
 */
@Transactional
public interface LojaRepository extends CrudRepository<Loja, Long> {
    Loja findByUsuario(Usuario usuario);
}
