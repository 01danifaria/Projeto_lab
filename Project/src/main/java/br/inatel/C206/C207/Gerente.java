package br.inatel.C206.C207;

public class Gerente extends Chefe{

    protected String idGerente;
    protected String faturamento;

    public Gerente(String nomeSobrenome, String telefone, String idGerente) {
        super(nomeSobrenome, telefone, idGerente);
    }

    public void total(){
        if (faturamento != null) {
            System.out.println("Valor adicionado ao caixa");
            faturamento += faturamento;
        } else
            System.out.println("Nenhuma entrada de dinheiro ao caixa, paciente possuia convenio");
    }

    public String getFaturamento(String total) {
        return faturamento;
    }
}
