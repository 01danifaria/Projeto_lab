package br.inatel.C206.C207;

import java.util.ArrayList;
import java.util.List;

public class Paciente implements Convenio {

    protected static int count = 1;
    protected String NomeSobrenome;
    protected String telefone;
    protected String endereco;
    public int idPaciente;
    public String valorConsulta;
    protected String CPF;
//se der certo faz SEXO

    public Paciente(String nomeSobrenome, String telefone, String endereco, int idPaciente, String valorConsulta, String CPF) {
        this.NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idPaciente = count;
        this.valorConsulta = valorConsulta;
        this.CPF = CPF;

    }

    Paciente() {

    }

    @Override
    public String Convenio() {
        System.out.println("Paciente usou seu convenio");
        return NomeSobrenome;
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
        return valorConsulta;
    }

    public String setValorConsulta() {
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


