package com.jid.controllers;

import com.jid.util.Sha;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() throws NoSuchAlgorithmException {
        System.out.println(Sha.hash256("123456"));
        System.out.println("oi");

        return "index";
    }
}
