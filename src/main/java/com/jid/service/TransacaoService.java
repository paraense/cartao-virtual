package com.jid.service;

import com.jid.daos.TransacaoRepository;
import com.jid.models.Cliente;
import com.jid.models.EstadoTransacao;
import com.jid.models.Loja;
import com.jid.models.Transacao;
import com.jid.util.Sha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by igor on 28/11/15.
 */
@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private SessionService sessionService;

    @Transactional
    public Integer realizaVenda(Cliente cliente, BigDecimal valor) {
        Loja loja = sessionService.getLojaLogada();

        Transacao transacao = new Transacao();
        transacao.setData(Calendar.getInstance());
        transacao.setDescricao("");
        transacao.setCliente(cliente);
        transacao.setLoja(loja);
        transacao.setEstado(EstadoTransacao.AGUARDANDO);
        transacao.setValor(valor);

        transacao.setCodigo(Sha.bytesToHex((new BigInteger(40, new Random())).toByteArray()).substring(0, 6));

        transacaoRepository.save(transacao);

        return transacao.getId();
    }

    public void aprovar(Transacao transacao, String codigo) {
        if (transacao.getValor().compareTo(transacao.getCliente().getSaldo()) > 0) {
            throw new RuntimeException("Saldo Insuficiente");
        }

        transacao.setDataAtualizacao(Calendar.getInstance());

        if (!transacao.getCodigo().equals(codigo)) {
            transacao.setEstado(EstadoTransacao.REJEITADA);
            transacaoRepository.save(transacao);
            throw new RuntimeException("Código incorreto, realize a venda novamente");
        }

        transacao.getCliente().setSaldo(transacao.getCliente().getSaldo().subtract(transacao.getValor()));
        transacao.setEstado(EstadoTransacao.APROVADA);

        transacaoRepository.save(transacao);
    }

    public void aprovar(Integer id, String codigo) {
        Transacao transacao = transacaoRepository.findOne(id);

        if (transacao == null) {
            throw new RuntimeException("Transação não existe");
        }

        aprovar(transacao, codigo);
    }
}
