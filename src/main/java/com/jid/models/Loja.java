package com.jid.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by igor on 28/11/15.
 */
@Entity
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String ramoDeAtividade;

    @OneToMany
    @JoinColumn(name = "loja")
    private List<Transacao> trsansacoes;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Usuario usuario;

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

    public String getRamoDeAtividade() {
        return ramoDeAtividade;
    }

    public void setRamoDeAtividade(String ramoDeAtividade) {
        this.ramoDeAtividade = ramoDeAtividade;
    }

    public List<Transacao> getTrsansacoes() {
        return trsansacoes;
    }

    public void setTrsansacoes(List<Transacao> trsansacoes) {
        this.trsansacoes = trsansacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
