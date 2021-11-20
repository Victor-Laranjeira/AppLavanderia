package com.example.applavanderia.activity.util;

import java.util.HashMap;

public class ParseErrors {

    private HashMap<Integer, String> erros;

    public ParseErrors() {
        this.erros = new HashMap<>();
        this.erros.put(201, "A senha não foi preenchida.");
        this.erros.put(202, "Usuário já exite.");
        this.erros.put(200, "O usuário não foi preenchido");
        this.erros.put(203, "O E-mail já está sendo usado");
        this.erros.put(204, "O E-mail não foi preenchido");
        this.erros.put(205, "Um usuário com o E-mail especificado não foi encontrado");
        this.erros.put(207, "O usuário só pode ser criado através do cadastro");
        this.erros.put(208, "A conta já está logada em outro dispositivo");
        this.erros.put(-1, "Um erro desconhecido ou não relacionado ao Parse ocorreu");
    }

    public String getErro(int codErro) {
        return this.erros.get(codErro);
    }

}
