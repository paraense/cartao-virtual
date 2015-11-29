package com.jid.controllers;

import com.jid.service.PagSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author John
 */
@Controller
@RequestMapping(value = "/pag-seguro")
@Transactional
public class PagSeguroController {
    
    @Autowired
    private PagSeguroService pagSeguroService;
    
    @RequestMapping(value = "/notificacao", method = RequestMethod.POST)
    @ResponseBody
    public void notificacao(@RequestParam String notificationCode){
        System.out.println("Recebi notificação:"+ notificationCode);
        pagSeguroService.consultaTransacao(notificationCode);
        
    }
    
}
