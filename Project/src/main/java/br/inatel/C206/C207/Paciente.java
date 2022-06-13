package br.inatel.C206.C207;

public class Paciente {

    protected static int count = 1;
    protected String NomeSobrenome;
    protected String telefone;
    protected String endereco;
    public int idPaciente = 0;
    public int valorConsulta = 0;
    protected String CPF;
//se der certo faz SEXO


    public Paciente(String nomeSobrenome, String telefone, String endereco, String CPF, int valorConsulta) {
        NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.valorConsulta = valorConsulta;
        idPaciente++;
        this.CPF = CPF;
    }

    Paciente() {

    }

    public void Consulta(int valor) {
        try {
            if (valor >= valorConsulta) {
                throw new ValorConsultaInvalidaException(valor);
            } else {
                System.out.println("Voce inseriu o valor da consulta: " + valor);
            }
        } catch (
                ValorConsultaInvalidaException e) {
        }
        System.out.println("valor da consulta: " + this.valorConsulta);
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

    public String setEndereco(String endereco) {
        return endereco;
    }

    public int getValorConsulta() {
        return valorConsulta;
    }

    public int setValorConsulta(int valorConsulta) {
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


