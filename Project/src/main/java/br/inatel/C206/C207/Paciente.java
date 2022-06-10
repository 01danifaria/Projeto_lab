package br.inatel.C206.C207;

public class Paciente  {

    protected static int count = 1;
    protected String NomeSobrenome;
    protected String telefone;
    protected String endereco;
    public int idPaciente;
    public String valorConsulta;
    protected String CPF;
//se der certo faz SEXO

    public Paciente(String nomeSobrenome, String s, String telefone, String endereço) {
        this.NomeSobrenome = nomeSobrenome;
        this.telefone = this.telefone;
        this.endereco = endereco;
        this.idPaciente = count;
        this.valorConsulta = valorConsulta;
        this.CPF = CPF;

    }

    Paciente() {

    }

    public String getNomeSobrenome() {
        return NomeSobrenome;
    }

    public String setNomeSobrenome(String nome) {
        return NomeSobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String setTelefone(String telefone) {
        return this.telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String setEndereco() {
        return endereco;
    }

    public String getValorConsulta() {
        return null;
    }

    public String setValorConsulta(String valor) {
        return valorConsulta;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdPaciente() {
        return count;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}


