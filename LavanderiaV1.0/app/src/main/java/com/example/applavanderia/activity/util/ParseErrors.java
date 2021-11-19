package com.example.applavanderia.activity.util;

import java.util.HashMap;

public class ParseErrors {

    private HashMap<Integer, String> erros;

    public ParseErrors() {
        this.erros = new HashMap<>();
        this.erros.put(201, "A senha não fio preenchida.");
        this.erros.put(202, "Usuário já exite.");
    }

    public String getErro(int codErro) {
        return this.erros.get(codErro);
    }

}
