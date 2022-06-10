package br.inatel.C206.C207;

public class ValorConsultaInvalidaException extends Exception {

    public String ValorConsultaInvalidaException(String valor) {
        System.out.println("Insira um valor difererente do inserido " + valor);
        return valor;
    }

}