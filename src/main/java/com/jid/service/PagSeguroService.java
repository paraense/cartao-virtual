package com.jid.service;

import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.enums.DocumentType;
import java.math.BigDecimal;


public class PagSeguroService {

    public void efetuaCheckout() {
        Checkout checkout = new Checkout();
        checkout.addItem(null, "Televisor 32 polegadas - Lojas Americanas", 
                1, new BigDecimal("1200,00"), Long.MIN_VALUE, BigDecimal.ZERO);
         
        checkout.setSender("John Gomes da Silva", "johngomez13@gmail.com", 
                "91","98347965", DocumentType.CPF, "003.774.322.88");
        
        checkout.setReference("COD-DE-REFERENCIA");
        checkout.setRedirectURL("http://www.cartaovirtual.com.br/profile");
        checkout.setNotificationURL("http://www.cartaovirtual.com.br/notificacao");
        
        
        
      
    }

}
