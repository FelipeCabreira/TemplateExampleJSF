package com.templatejsf.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NomeSistema {
    private static final String nomeAbreviado = "GTEL";
    private static final String nomeCompleto = "Sistema de Gestão da Telefonia Móvel";

    public String getNomeAbreviado(){
        return nomeAbreviado;
    }

    public static String getNomeCompleto() {
        return nomeCompleto;
    }
}
