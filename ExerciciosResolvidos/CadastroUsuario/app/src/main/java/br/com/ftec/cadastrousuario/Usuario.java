package br.com.ftec.cadastrousuario;

import java.io.Serializable;

/**
 * Created by CASSIUS on 23/04/2017.
 */

class Usuario implements Serializable {

    private String nome;
    private String telefone;
    private String email;
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
