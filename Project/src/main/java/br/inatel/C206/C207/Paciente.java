package br.inatel.C206.C207;

public class Paciente {

    private static int cont;
    protected String NomeSobrenome;
    protected String telefone;
    protected String endereco;
    public int idPaciente = 1;
    protected String valorConsulta;
    protected String cpf;
    protected String sexo;

    public Paciente(String nomeSobrenome, String telefone, String endereco, String valorConsulta, String cpf) {
        this.NomeSobrenome = nomeSobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.sexo = sexo;
        this.valorConsulta = valorConsulta;
        cont++;
        this.idPaciente = cont;
    }

    public void mostraId(){
        System.out.println("ID do paciente: " + this.idPaciente);
    }

    public static int getCont() {
        return Paciente.cont;
    }

    public static void setCont(int cont) {
        Paciente.cont = cont;
    }

    Paciente() {

    }

    public String getNomeSobrenome() {
        return NomeSobrenome;
    }

    public void setNomeSobrenome(String nomeSobrenome) {
        NomeSobrenome = nomeSobrenome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public int setIdPaciente(int idPaciente) {
        return idPaciente;
    }

    public String getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(String valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Object valorConsulta() {return this.valorConsulta;}
}




