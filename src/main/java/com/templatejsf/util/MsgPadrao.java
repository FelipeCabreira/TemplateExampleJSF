package com.templatejsf.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class MsgPadrao implements Serializable {
    private final String confirmaDeletar = "Confirma deletar o registro? Esta operação NÃO poderá ser desfeita!";

    public String getConfirmaDeletar() {
        return confirmaDeletar;
    }
}
