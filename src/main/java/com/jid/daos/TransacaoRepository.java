package com.jid.daos;

import com.jid.models.Transacao;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by igor on 28/11/15.
 */
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
