package com.jid.controllers;

import com.jid.models.PermissaoUsuario;
import com.jid.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    public SessionService sessionService;

    @RequestMapping("/")
    public String index() {
        PermissaoUsuario permissao = sessionService.getUsuarioLogado().getPermissao();

        System.out.println(permissao);

        if (permissao.equals(PermissaoUsuario.CLIENTE)) {
            return "redirect:/cliente/home";
        }
        else if (permissao.equals(PermissaoUsuario.LOJA)) {
            return "redirect:/loja/home";
        }

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login2";
    }

    @RequestMapping("/usuario")
    @ResponseBody
    public String usuario() {
        return sessionService.getUsuarioLogado().getNome();
    }
}
