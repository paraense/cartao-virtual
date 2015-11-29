package com.jid.controllers;

import com.jid.daos.ClienteRepository;
import com.jid.daos.UsuarioRepository;
import com.jid.models.Cliente;
import com.jid.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by igor on 29/11/15.
 */
@Controller
@RequestMapping("/loja")
public class LojaController {
    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/venda")
    public String venda() {
        return "venda";
    }

    @RequestMapping(value = "/venda", method = RequestMethod.POST)
    @ResponseBody
    public String realizaVenda(@RequestParam BigDecimal valor, @RequestParam String cpf) {
//        Cliente cliente = clienteRepository.findByUsuario(usuarioRepository.findByCpf(cpf));
        return "";
    }
}
