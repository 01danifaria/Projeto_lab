package br.inatel.C206.C207;

public class ValorConsultaInvalidaException extends Exception {

    public ValorConsultaInvalidaException(int valor) {
        System.out.println("Voce tentou adicionar um valor, mas o valor não é aceitável");
    }

}