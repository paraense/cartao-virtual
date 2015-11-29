package com.jid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by igor on 29/11/15.
 */
@Controller
@RequestMapping("/loja")
public class LojaController {
    @RequestMapping("/venda")
    public String venda() {
        return "venda";
    }
}
