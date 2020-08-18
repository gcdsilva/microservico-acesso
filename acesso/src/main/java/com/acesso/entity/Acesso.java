package com.acesso.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(value="porta_id")
    private Long portaId;

    @JsonProperty(value="cliente_id")
    private Long clienteId;

    public Acesso(Long id, Long id1) {
        this.clienteId = id1;
        this.portaId = id;
    }

    public Acesso() {
    }

    public Long getPortaId() {
        return portaId;
    }

    public void setPortaId(Long portaId) {
        this.portaId = portaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
