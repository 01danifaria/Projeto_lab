package br.inatel.C206.C207;

public class ValorConsultaInvalidaException extends Exception{

    public ValorConsultaInvalidaException(String valor){
        System.out.println("Voce tentou entrar com nome diferente de Convenio ou menor ou igual a 0.");
    }
}