package br.com.dbc.contacorrente.main.classes;

public class Endereco {
    //tipo 1- residencial, 2- comercial
    private int tipo, numero;
    private String logradouro, complemento, cep, cidade, estado, pais;

    public Endereco(int tipo, int numero, String logradouro, String complemento, String cep, String cidade, String estado, String pais) {
            this.tipo = tipo;
            this.numero = numero;
            this.logradouro = logradouro;
            this.complemento = complemento;
            this.cep = cep;
            this.cidade = cidade;
            this.estado = estado;
            this.pais = pais;
    }

    public void imprimirEndereco() {
        System.out.println("Tipo do Endereço: " + tipo + "\n" +
                           "Logradouro: "       + logradouro + "\n" +
                           "Complemento: "      + complemento + "\n" +
                           "CEP:"               + cep + "\n" +
                           "Estado: "           + estado + "\n" +
                           "País: "             + pais);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
