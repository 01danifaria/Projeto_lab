package br.inatel.C206.C207;

public class Chefe implements Dinheiro {

    protected String NomeSobrenome;
    protected String telefone;
    protected String  idChefe;
    protected String faturamento;

    public Chefe(String nomeSobrenome, String telefone, String idChefe) {
        NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.idChefe = idChefe;
    }

    public String total(){
        if (faturamento != null) {
            System.out.println("Valor adicionado ao caixa");
        } else
            System.out.println("Nenhuma entrada de dinheiro ao caixa, paciente possuia convenio");
        return null;
    }

    public String getFaturamento() {
        return faturamento;
    }

    @Override
    public String dinheiro(String message) {
        System.out.println("O dinheiro foi recebido");
        return getFaturamento();
    }

}
