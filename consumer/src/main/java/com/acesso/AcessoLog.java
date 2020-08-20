package com.acesso;

public class AcessoLog {

    private Long portaId;

    private Long clienteId;

    private boolean Autorizado;

    public Long getPortaId() {
        return portaId;
    }

    public void setPortaId(Long portaId) {
        this.portaId = portaId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public boolean isAutorizado() {
        return Autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        Autorizado = autorizado;
    }
}
