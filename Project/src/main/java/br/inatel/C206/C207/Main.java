package br.inatel.C206.C207;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ValorConsultaInvalidaException {
        int op;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String nome;
        String telefone;
        String endereco;
        String cpf;
        String valorConsulta;
        String sexo;

        ArrayList<Paciente> p = new ArrayList<Paciente>();
        while (flag) {
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Buscar paciente");
            System.out.println("3 - Adicionar dinheiro ao caixa");
            System.out.println("4 - Inserir médicos");
            System.out.println("5 - CRUD");
            System.out.println("6 - Sair");
            System.out.println("Sua opção: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    Paciente p1 = new Paciente();
                    System.out.println("Entre com as informaçoes: ");
                    System.out.println("ID do Paciente: " + p1.idPaciente++);
                    sc.nextLine();
                    System.out.println("Digite o se a consulta foi por convenio ou  Particular  ");
                    valorConsulta = sc.nextLine();
                    p1.setValorConsulta(valorConsulta);
                    for (int i = 0; i < p.size(); i++) {
                        if (p1.valorConsulta().equals("Convenio")) {
                            System.out.println("Paciente usou seu convenio  ");
                        }
                        else {
                            System.out.println(p1.getValorConsulta());
                        }
                    }

                    System.out.println("Digite o nome do paciente: ");
                    nome = sc.nextLine();
                    p1.setNomeSobrenome(nome);
                    System.out.println("Digite o CPF do paciente: ");
                    cpf = sc.nextLine();
                    p1.setcpf(cpf);
                    System.out.println("Digite o Telefone do paciente: ");
                    telefone = sc.nextLine();
                    p1.setTelefone(telefone);
                    System.out.println("Digite o endereço do paciente: ");
                    endereco = sc.nextLine();
                    p1.setEndereco(endereco);
                    System.out.println("Digite o sexo: ");
                    sexo = sc.nextLine();
                    p1.setSexo(sexo);
                    p.add(p1);//adiciona o paciente atual à nossa lista de pacientes
                    System.out.println("Paciente cadastrado! ");
                    break;
                case 2:
                    System.out.println("Digite o cpf do paciente a ser pesquisado: ");
                    Scanner input = new Scanner(System.in);
                    cpf = input.nextLine();
                    for (int i = 0; i < p.size(); i++) {
                        if (p.get(i).getcpf().equals(cpf)) {
                            System.out.println(p.get(i).getNomeSobrenome());
                            System.out.println(p.get(i).getTelefone());
                            System.out.println(p.get(i).getEndereco());
                            System.out.println(p.get(i).getSexo());
                        }
                        else
                            System.out.println("Paciente não encontrado");
                    }

                    break;

                case 3:
                    Funcionario func = new Funcionario("Julia Alcantara","364521452", "1");
                    func.dinheiro("Dinheiro foi adicionado ao caixa por " + func);
                    break;

                case 4:
                    String nom, tel, especialide, crm;
                    sc.nextLine();

                    Medico me1 = new Medico();
                    System.out.println("Digite o nome do médico: ");
                    nom = sc.nextLine();
                    me1.getNome();

                    System.out.println("Digite o telefone do médico: ");
                    tel = sc.nextLine();
                    me1.getTel();

                    System.out.println("Digite a especialidade do médico: ");
                    especialide = sc.nextLine();
                    me1.getEspecialidade();

                    System.out.println("Digite o CRM do médico: ");
                    crm = sc.nextLine();
                    me1.getCRM();

                case 5:
                    PacienteDB pacienteDB = new PacienteDB();

                    Paciente paciente1 = new Paciente("Antonia dos Santos", "111.111.11.00", "147582", "Rua das Palmeiras", "100");
                    Paciente paciente2 = new Paciente("José Faria", "1114.4556.00", "158935", "Avenida dos lagos", "200");
                    Paciente paciente3 = new Paciente("Marco da Silva", "4785.25474.45","789665","Avenida dos anjos","300");

                    pacienteDB.insertPaciente(paciente1);
                    pacienteDB.insertPaciente(paciente2);
                    pacienteDB.insertPaciente(paciente3);

                    pacienteDB.reserachPaciente();

                    System.out.println("--------Atualizando nome e sobrenome--------");
                    pacienteDB.updatePaciente(1, "Flavia");
                    pacienteDB.reserachPaciente();

                    System.out.println("--------Excluindo usuário--------");
                    pacienteDB.deletePaciente(1);
                    pacienteDB.reserachPaciente();
                    break;

                case 6:
                    System.out.println("Voce saiu!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }

    }
}