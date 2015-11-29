package com.jid.daos;

import com.jid.models.Transacao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 28/11/15.
 */
public interface TransacaoRepository extends CrudRepository<Transacao, Integer> {
    
}
