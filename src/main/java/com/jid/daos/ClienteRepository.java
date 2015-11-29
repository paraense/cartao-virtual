package com.jid.daos;

import com.jid.models.Cliente;
import com.jid.models.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 28/11/15.
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByUsuario(Usuario usuario);
    Cliente findByCpf(String cpf);
}
