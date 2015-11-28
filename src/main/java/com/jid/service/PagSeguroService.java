package com.jid.service;

import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import com.jid.models.Cliente;
import java.math.BigDecimal;

public class PagSeguroService {

    private String resposta;

    public String efetuaCheckout(Cliente cliente, BigDecimal valor) {

        Checkout checkout = new Checkout();
        checkout.addItem("GERAR-CÓDIGO", "Recarga de créditos - Cartão virtual",
                1, valor, Long.MIN_VALUE, BigDecimal.ZERO);

        //tratar ddd de celular
        checkout.setSender(cliente.getNome(), cliente.getUsuario().getEmail(),
                "91", cliente.getUsuario().getCelular(), DocumentType.CPF, cliente.getCpf());

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

}
