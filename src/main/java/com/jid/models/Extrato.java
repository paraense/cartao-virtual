package com.jid.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by igor on 28/11/15.
 */
@Entity
public class Extrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Calendar data;

    private BigDecimal valor;

    private TipoExtrato tipoExtrato;

    @ManyToOne
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoExtrato getTipoExtrato() {
        return tipoExtrato;
    }

    public void setTipoExtrato(TipoExtrato tipoExtrato) {
        this.tipoExtrato = tipoExtrato;
    }
}
