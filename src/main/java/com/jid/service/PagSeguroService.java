package com.jid.service;

import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.NotificationService;
import com.jid.daos.ExtratoRepository;
import com.jid.models.Cliente;
import com.jid.models.Extrato;
import com.jid.models.StatusExtrato;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagSeguroService {

    private String resposta;
    private Extrato extrato;

    @Autowired
    private ExtratoRepository extratoRepository;

    @Autowired
    private ClienteService clienteService;

    public String efetuaCheckout(Cliente cliente, BigDecimal valor) {

        Checkout checkout = new Checkout();
        checkout.addItem("GERAR-CÓDIGO", "Recarga de créditos - Cartão virtual",
                1, valor, Long.MIN_VALUE, BigDecimal.ZERO);

        String ddd = cliente.getUsuario().getCelular().substring(1, 2);
        System.out.println(ddd);
        //tratar ddd de celular
        checkout.setSender(cliente.getNome(), cliente.getUsuario().getEmail(),
                ddd, cliente.getUsuario().getCelular(), DocumentType.CPF, cliente.getCpf());

        checkout.setReference("COD-DE-REFERENCIA-GERAR");
        checkout.setRedirectURL("http://www.cartaovirtual.com.br/profile");
        checkout.setNotificationURL("http://www.cartaovirtual.com.br/notificacao");

        try {
            boolean onlyCheckOutCod = false;
            resposta
                    = checkout.register(PagSeguroConfig.getAccountCredentials(), onlyCheckOutCod);
        } catch (Exception e) {
        }
        return resposta;
    }

    public void consultaTransacao(String codigoNotificacao) {

        Transaction transacao = null;
        try {
            transacao = NotificationService
                    .checkTransaction(PagSeguroConfig.getAccountCredentials(), codigoNotificacao);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

        if (transacao != null) {
            extrato = extratoRepository
                    .findByCodReferencia(transacao.getReference());
            extrato = clienteService.atualizaStatusExtrato(extrato, transacao);
            
            if (extrato != null) {
                if (extrato.getStatus().equals(StatusExtrato.APROVADA)) {
                    clienteService.creditaValor(extrato, transacao);

                }
            }
        }

    }

}
