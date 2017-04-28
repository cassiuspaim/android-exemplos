package br.com.ftec.listacontatos;

/**
 * Created by CASSIUS on 23/04/2017.
 */

class Contato {

    private String nomeCompleto;
    private String primeiroNome;
    private String ultimoNome;
    private String profissao;
    private boolean hasTrofeu;

    public Contato(String nomeCompleto, String primeiroNome, String ultimoNome, String profissao, boolean hasTrofeu) {
        this.nomeCompleto = nomeCompleto;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.profissao = profissao;
        this.hasTrofeu = hasTrofeu;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public boolean hasTrofeu() {
        return hasTrofeu;
    }
}
