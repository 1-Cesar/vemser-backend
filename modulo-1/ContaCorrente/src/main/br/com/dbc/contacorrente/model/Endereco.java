package main.br.com.dbc.contacorrente.model;

public class Endereco {
    public int tipo, numero;
    public String logradouro, complemento, cep, cidade, estado, pais;
    public void imprimirEndereco() {
        System.out.println("\n--------------------");
        if (tipo == 1) {
            System.out.println("\nLogradouro: " + logradouro  + "\n" +
                    "Complemento: "             + complemento + "\n" +
                    "Número: "                  + numero      + "\n" +
                    "CEP: "                     + cep         + "\n" +
                    "Cidade: "                  + cidade      + "\n" +
                    "Estado: "                  + estado      + "\n" +
                    "País: "                    + pais        + "\n" +
                    "Tipo: "                    + tipo);
        }
        if (tipo == 2) {
            System.out.println("\nLogradouro: " + logradouro  + "\n" +
                    "Complemento: "             + complemento + "\n" +
                    "Número: "                  + numero      + "\n" +
                    "CEP: "                     + cep         + "\n" +
                    "Cidade: "                  + cidade      + "\n" +
                    "Estado: "                  + estado      + "\n" +
                    "País: "                    + pais        + "\n" +
                    "Tipo: "                    + tipo);
        }
    }
}
