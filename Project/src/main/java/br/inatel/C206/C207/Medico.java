package br.inatel.C206.C207;

public class Medico {

    protected String Nome;
    protected String tel;
    protected String especialidade;
    protected String CRM;

    public Medico() {
        this.Nome = Nome;
        this.tel = tel;
        this.especialidade = especialidade;
        this.CRM = CRM;
    }

    public String getNome(String nome) {
        return Nome;
    }

    public String setNome(String nome) {
        return nome;
    }

    public String getTel(String tel) {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEspecialidade(String especialide) {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCRM(int crm) {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }
}
