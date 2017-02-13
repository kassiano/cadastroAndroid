package br.com.helloworld.helloworld;

import java.io.Serializable;

/**
 * Created by sn1041520 on 06/02/2017.
 */
public class Usuario implements Serializable {

    private String Nome;
    private String Email;
    private String Senha;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
