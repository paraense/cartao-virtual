package com.jid.daos;

import com.jid.models.Cliente;
import com.jid.models.Extrato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by igor on 28/11/15.
 */
public interface ExtratoRepository extends CrudRepository<Extrato, Long> {
    List<Extrato> findByCliente(Cliente cliente);
    
    Extrato findByExtratoPorCod(String cod);
}
