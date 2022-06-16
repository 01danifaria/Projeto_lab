package br.inatel.C206.C207;

public class Funcionario {

    protected String NomeSobrenome;
    protected String telefone;
    protected int idFunconario;


    public Funcionario(String nomeSobrenome, String telefone, int idFuncionario) {
        NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.idFunconario = idFuncionario;
    }

    Funcionario(){
    }

    public String getNomeSobrenome() {
        return NomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        NomeSobrenome = nomeSobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdFunconario() {
        return idFunconario;
    }

    public int setIdFunconario(int idF) {
        return idFunconario;
    }
}
