package com.jid.controllers;

import com.jid.daos.ClienteRepository;
import com.jid.daos.UsuarioRepository;
import com.jid.models.Cliente;
import com.jid.models.Usuario;
import com.jid.service.ClienteService;
import com.jid.service.SessionService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public String realizaRecarga(String valor) {
        try {
            return "redirect:" + clienteService.efetuarRecarga(new BigDecimal(valor));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "erro";
        }
    }

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    @ResponseBody
    public Cliente buscaUsuario(@RequestParam("celular") String celular) {

        Usuario u = usuarioRepository.findByCelular(celular);
        if (u != null) {
            return clienteRepository.findByUsuario(u);
        }
        return null;
    }

    @RequestMapping(value = "/transferir", method = RequestMethod.POST)
    @ResponseBody
    public void tranfereValor(@RequestParam Cliente destinatario, @RequestParam BigDecimal valor) {
        clienteService.tranferencia(destinatario, valor);

    }

    @RequestMapping(value = "/buscaCpf/{cpf}")
    @ResponseBody
    public Cliente buscaCpf(@PathVariable String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

}
