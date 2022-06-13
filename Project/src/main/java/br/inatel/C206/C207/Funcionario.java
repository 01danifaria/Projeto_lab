package br.inatel.C206.C207;

public class Funcionario implements FuncResponsavel {

    protected String NomeSobrenome;
    protected String telefone;
    protected String  idFunconario;


    public Funcionario(String nomeSobrenome, String telefone, String idFuncionario) {
        NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.idFunconario = idFuncionario;
    }

    @Override
    public String FuncResponsavel(String message) {
        System.out.println("Funcionário responsável pelos cadastros " + NomeSobrenome);
        return message;
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

    public String getIdFunconario() {
        return idFunconario;
    }

    public void setIdFunconario(String idFunconario) {
        this.idFunconario = idFunconario;
    }
}
