package com.jid.daos;

import com.jid.models.Loja;
import com.jid.models.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 28/11/15.
 */
public interface LojaRepository extends CrudRepository<LojaRepository, Long> {
    Loja findByUsuario(Usuario usuario);
}
