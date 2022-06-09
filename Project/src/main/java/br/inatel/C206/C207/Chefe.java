package br.inatel.C206.C207;

public class Chefe implements Dinheiro {

    protected String NomeSobrenome;
    protected String telefone;
    protected String  idChefe;

    public Chefe(String nomeSobrenome, String telefone, String idChefe) {
        NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.idChefe = idChefe;
    }


    @Override
    public String dinheiro() {
        System.out.println("O dinheiro foi recebido");
        return this.idChefe;
    }

}
