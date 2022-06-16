package br.inatel.C206.C207;

public class Paciente {

    protected String NomeSobrenome;
    protected String telefone;
    protected String endereco;
    public int idPaciente;
    protected int valorConsulta;
    protected String cpf;
    public int fk_funcionario;

    public Paciente(String nomeSobrenome, String telefone,String endereco, int valorConsulta, String cpf) {
        this.NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.valorConsulta = valorConsulta;
    }

    Paciente() {

    }

    public String getNomeSobrenome() {
        return NomeSobrenome;
    }

    public int getFk_funcionario() {
        return fk_funcionario;
    }

    public void setFk_funcionario(int fk_funcionario) {
        this.fk_funcionario = fk_funcionario;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        NomeSobrenome = nomeSobrenome;
    }

    public String getcpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int setIdPaciente(int idP) {
        return idPaciente;
    }

    public int getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(int valorConsulta) {
        this.valorConsulta = this.valorConsulta;
    }

    public Object valorConsulta() {return this.valorConsulta;}

    public void setcpf(String cpf) {
    }
}




