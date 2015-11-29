package com.jid.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by igor on 29/11/15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/home")
    public String home() {
        return "admin";
    }
}
