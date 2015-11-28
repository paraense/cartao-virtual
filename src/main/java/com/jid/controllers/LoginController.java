package com.jid.controllers;

import com.jid.models.PermissaoUsuario;
import com.jid.models.Usuario;
import com.jid.service.JidUserDetailsService;
import com.jid.service.UsuarioService;
import com.jid.util.Sha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

/**
 * Created by igor on 28/11/15.
 */
//@Controller("/login")
@RestController("/login")
public class LoginController {
    @Autowired
    private JidUserDetailsService userDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String senha, HttpServletRequest request) throws NoSuchAlgorithmException {
        UserDetails person = userDetailsService.loadUserByUsername(email);

        if (person == null) {
            return "usuario";
        }

        if (!person.getPassword().equals(Sha.hash256(senha))) {
            return "senha";
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(person, null, person.getAuthorities());
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

        for (GrantedAuthority g : person.getAuthorities()) {
            if (g.getAuthority().equals(PermissaoUsuario.ADMIN.toString())) {
                return "admin";
            }
            if (g.getAuthority().equals(PermissaoUsuario.CLIENTE.toString())) {
                return "cliente";
            }
            if (g.getAuthority().equals(PermissaoUsuario.LOJA.toString())) {
                return "loja";
            }
        }

        return "";
    }

//    @RequestMapping("/gogo")
//    public String gogo() {
////        Usuario u = new Usuario();
////        u.setEmail("igor@igor.com");
////        u.setSenha("123456");
////        u.setCelular("12345678");
////        u.setNome("Igor");
////
//        System.out.println("oi");
//        usuarioService.cadastra(u, PermissaoUsuario.CLIENTE);

//
//        return "oi";
//    }
}
