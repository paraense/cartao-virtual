/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jid.controllers;

import com.jid.daos.ClienteRepository;
import com.jid.models.Cliente;
import com.jid.models.Usuario;
import com.jid.service.ClienteService;
import com.jid.service.SessionService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author John
 */
@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private SessionService session;
    
    @Autowired
    private ClienteService clienteService;
    
    
    
    private ModelAndView mav;
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        
        Cliente cliente = session.getClienteLogado();
        this.mav = new ModelAndView();
        this.mav.addObject("cliente", cliente);
        this.mav.setViewName("home");
        return this.mav;
    }
    
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    @ResponseBody
    public String cadastrar(@RequestParam Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            return "sucesso";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "erro";
        }
    }
    
    @RequestMapping(value = "/recarregar", method = RequestMethod.POST)
    @ResponseBody
    public String realizaRecarga(String valor) {
        try {
            clienteService.efetuarRecarga(new BigDecimal(valor));
            return "sucesso";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "erro";
        }
    }
    
    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    @ResponseBody
    public void buscaUsuario(@RequestParam("celular") String celular) {
        //busca usuario e tras a informações
    }
    
    @RequestMapping(value = "/transferir", method = RequestMethod.POST)
    @ResponseBody
    public void tranfereValor(Cliente destinatario, BigDecimal valor) {
        clienteService.tranferencia(destinatario, valor);
        
    }
    
}
