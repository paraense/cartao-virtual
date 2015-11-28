package com.jid.controllers;

import com.jid.daos.ExtratoRepository;
import com.jid.models.Extrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by igor on 28/11/15.
 */
@Controller("/extrato")
public class ExtratoController {
    @Autowired
    private ExtratoRepository extratoRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Extrato> lista() {
        return extratoRepository.findByCliente(null);
    }
}
