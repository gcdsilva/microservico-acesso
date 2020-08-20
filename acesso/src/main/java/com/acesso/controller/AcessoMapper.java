package com.acesso.controller;

import com.acesso.AcessoLog;
import com.acesso.entity.Acesso;

public class AcessoMapper {


    public static AcessoLog from(Acesso acesso) {

        AcessoLog acessoLog = new AcessoLog();
        acessoLog.setAutorizado(true);
        acessoLog.setClienteId(acesso.getClienteId());
        acessoLog.setPortaId(acesso.getPortaId());

        return acessoLog;
    }
}
