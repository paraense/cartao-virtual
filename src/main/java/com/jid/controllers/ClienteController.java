/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jid.controllers;

import com.jid.daos.ClienteRepository;
import com.jid.models.Cliente;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author John
 */
@Controller("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@RequestParam Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            return "sucesso";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "erro";
        }
    }
    
    

}
