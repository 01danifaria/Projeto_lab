package br.inatel.C206.C207;

public class Medico{

    protected String Nome;
    protected String tel;
    protected String especialidade;
    protected int CRM;

    public Medico() {
        this.Nome = Nome;
        this.tel = tel;
        this.especialidade = this.especialidade;
        this.CRM = CRM;
    }

    public String getNome() {
        return Nome;
    }

    public String setNome(String nome) {
        return nome;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int  CRM) {
        this.CRM = CRM;
    }

}
