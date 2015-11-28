package com.jid.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by igor on 28/11/15.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String senha;

    @NotNull
    @Column(unique = true)
    private String celular;

    private PermissaoUsuario permissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public PermissaoUsuario getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoUsuario permissao) {
        this.permissao = permissao;
    }
}
