package br.inatel.C206.C207;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, ValorConsultaInvalidaException {
        int op;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String nome, telefone, endereco, cpf;
        int valorConsulta = 0, idPaciente = 0;
        ArrayList<Paciente> p = new ArrayList<Paciente>();

        while (flag) {
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Buscar paciente");
            System.out.println("3 - Adicionar dinheiro ao caixa");
            System.out.println("4 - Inserir médicos");
            System.out.println("5 - CRUD ");
            System.out.println("6 - Sair");
            System.out.println("Sua opção: ");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    sc.nextLine();
                    Paciente p1 = new Paciente();

                    System.out.println("ID do Paciente: " + p1.idPaciente++);

                System.out.println("Digite o valor da consulta: ");
                valorConsulta = sc.nextInt();
                p1.setValorConsulta(valorConsulta);
                p1.Consulta(200);

                sc.nextLine();
                System.out.println("Digite o nome do paciente: ");
                nome = sc.nextLine();
                p1.setNomeSobrenome(nome);



                System.out.println("Digite o CPF do paciente: ");
                cpf = sc.nextLine();
                p1.setCPF(cpf);



                System.out.println("Digite o Telefone do paciente: ");
                telefone = sc.nextLine();
                p1.setTelefone(telefone);



                System.out.println("Digite o endereço do paciente: ");
                endereco = sc.nextLine();
                p1.setEndereco(endereco);




                p.add(p1);//adiciona o paciente atual à nossa lista de pacientes
                System.out.println("Paciente cadastrado! ");
                break;



                case 2:
                    System.out.println("Digite o cpf do paciente a ser pesquisado: ");
                    Scanner input = new Scanner(System.in);
                    cpf = input.nextLine();



                    for (int i = 0; i < p.size(); i++) {
                        if (p.get(i).getCPF().equals(cpf)) {
                            System.out.println(p.get(i).getNomeSobrenome());
                            System.out.println(p.get(i).getTelefone());
                            System.out.println(p.get(i).getEndereco());
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
                    Database database = new Database();
                    PacienteDB pacienteDB = new PacienteDB();
                    database.connect();

                    Paciente paciente1 = new Paciente("Antonia dos Santos", "111.111.11.00", "147582", "Rua das Palmeiras", 100);
                    Paciente paciente2 = new Paciente("José Faria", "1114.4556.00", "158935", "Avenida dos lagos", 200);
                    Paciente paciente3 = new Paciente("Marco da Silva", "4785.25474.45","789665","Avenida dos anjos",300);


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