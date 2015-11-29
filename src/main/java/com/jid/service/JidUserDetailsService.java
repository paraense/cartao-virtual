package com.jid.service;

import com.jid.daos.UsuarioRepository;
import com.jid.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by igor on 28/11/15.
 */
@Service
public class JidUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        final Usuario u = usuarioRepository.findByEmail(username);

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> list = new ArrayList<>();
                list.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return u.getPermissao().toString();
                    }
                });

                return list;
            }

            @Override
            public String getPassword() {
                return u.getSenha();
            }

            @Override
            public String getUsername() {
                return u.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
