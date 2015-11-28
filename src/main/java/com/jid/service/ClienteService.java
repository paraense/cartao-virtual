package com.jid.service;

import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.service.NotificationService;
import com.jid.daos.ClienteRepository;
import com.jid.daos.ExtratoRepository;
import com.jid.models.Cliente;
import com.jid.models.Extrato;
import com.jid.models.StatusExtrato;
import com.jid.models.TipoExtrato;
import java.math.BigDecimal;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author John
 */
public class ClienteService {

    @Autowired
    private PagSeguroService pagSeguroService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ExtratoRepository extratoRepository;

    private Extrato extrato;

    public void efetuarRecarga(BigDecimal valor) {
        //pegar da sessão
        Cliente cliente = new Cliente();
        pagSeguroService.efetuaCheckout(cliente, valor);

        Extrato extrato = new Extrato();
        extrato.setTipoExtrato(TipoExtrato.ENTRADA);
        extrato.setStatus(StatusExtrato.EM_ANALISE);
        extrato.setValor(valor);
        extrato.setData(Calendar.getInstance());

        cliente.getExtratos().add(extrato);

        clienteRepository.save(cliente);

    }

    public void tranferencia(Cliente clienteReceptor, BigDecimal valor) {

        //pegar da sessão
        Cliente clientePagador = new Cliente();

        if (clientePagador.getSaldo().compareTo(valor) < 0) {
            System.out.println("O valor de tranferência é maior que o saldo");
            return;
        }
        finalizarTransferenciaPagador(clientePagador, clienteReceptor, valor);
        finalizarTransferenciaReceptor(clientePagador, clienteReceptor, valor);

    }

    public void finalizarTransferenciaPagador(Cliente clientePagador, Cliente clienteReceptor, BigDecimal valor) {

        Double valorFinal = clientePagador.getSaldo().doubleValue() - valor.doubleValue();
        clientePagador.setSaldo(new BigDecimal(valorFinal));

        Extrato extrato = new Extrato();
        extrato.setStatus(StatusExtrato.APROVADA);
        extrato.setTipoExtrato(TipoExtrato.SAIDA);
        extrato.setDescricao("Transferência de créditos para " + clienteReceptor.getNome());
        extrato.setData(Calendar.getInstance());
        clientePagador.getExtratos().add(extrato);

        clienteRepository.save(clientePagador);

    }

    public void finalizarTransferenciaReceptor(Cliente clientePagador, Cliente clienteReceptor, BigDecimal valor) {
        clienteReceptor.setSaldo(valor);

        Extrato extrato = new Extrato();
        extrato.setStatus(StatusExtrato.EM_USO);
        extrato.setTipoExtrato(TipoExtrato.ENTRADA);
        extrato.setDescricao("Vale Presente de  " + clientePagador.getNome());
        extrato.setData(Calendar.getInstance());
        clienteReceptor.getExtratos().add(extrato);

        clienteRepository.save(clienteReceptor);
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
                    .findByExtratoPorCod(transacao.getReference());
            extrato = atualizaStatusExtrato(extrato, transacao);
            
            if (extrato.getStatus().equals(StatusExtrato.APROVADA)) {    
                creditaValor(extrato, transacao);

            }
        }

    }

    public void creditaValor(Extrato extrato, Transaction transacao) {
        Cliente cliente = extrato.getCliente();
        Double valorAtual = cliente.getSaldo().doubleValue() + extrato.getValor().doubleValue();
        cliente.setSaldo(new BigDecimal(valorAtual));
        extrato.setStatus(StatusExtrato.EM_USO);
        extratoRepository.save(extrato);
        clienteRepository.save(cliente);
    }

    public Extrato atualizaStatusExtrato(Extrato extrato, Transaction transacao) {
        switch (transacao.getStatus().getValue()) {

            case 1:
                extrato.setStatus(StatusExtrato.EM_ANALISE);
                break;

            case 3:
                extrato.setStatus(StatusExtrato.APROVADA);
                break;

            case 6:
                extrato.setStatus(StatusExtrato.NAO_AUTORIZADO);
                break;

            case 7:
                extrato.setStatus(StatusExtrato.CANCELADO);
                break;

            default:

        }
        
        extratoRepository.save(extrato);
        return extrato;
    }

}
