package br.inatel.C206.C207;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;

public class Main {

    //criar criar, inserir, deletar, alterar
    public static void main(String[] args) throws IOException {

        ArrayList<Paciente> p = new ArrayList<Paciente>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String nome, telefone, endereco, cpf = null, valor = null;

        while (flag) {
            System.out.println("");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Buscar paciente");
            System.out.println("3 - Gerencia - Adicionar dinheiro ao caixa");
            System.out.println("4 - Inserir médicos");
            System.out.println("5 - Sair");
            System.out.println("Sua opção: ");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    sc.nextLine();
                    Paciente p1 = new Paciente();

                    System.out.println("!!!Entre com as informações do paciente!!!");

                    //não está incrementando
                    System.out.println("Código do paciente: " + p1.idPaciente++);

                    System.out.println("Entre com o valor da consulta: ");
                    valor = sc.nextLine();
                    p1.setValorConsulta(valor);

                    try { //arrumar
                        if (p1.valorConsulta != null) {
                            for (int i = 0; i < p.size(); i++) {
                                System.out.println("Entre com o valor da consulta");
                                valor = sc.nextLine();
                                p1.setValorConsulta(valor);
                            }
                        }else
                            throw new ValorConsultaInvalidaException();

                    }catch(ValorConsultaInvalidaException e) {
                        System.out.println(e);
                    }


                    System.out.println("Digite o nome e sobrenome: ");
                    nome = sc.nextLine();
                    p1.setNomeSobrenome(nome);


                    System.out.println("Digite o telefone: ");
                    telefone = sc.nextLine();
                    p1.setTelefone(telefone);

                    System.out.println("Digite e endereço: ");
                    endereco = sc.nextLine();
                    p1.setEndereco();

                    System.out.println("Digite o cpf do paciente: ");
                    cpf = sc.nextLine();
                    p1.setCPF(cpf);

                    p.add(p1);
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;

                case 2:

                    System.out.println("Digite o cpf do paciente: ");
                    cpf = sc.nextLine();

                    boolean encontrar = false;

                    for (int i = 0; i < p.size(); i++) {
                        Paciente encontrarPaciente = (Paciente) p.get(i);
                        if (encontrarPaciente.getCPF().equals(cpf)) {
                            System.out.println("CPF do paciente: " + encontrarPaciente.getCPF());
                            System.out.println("Nome do paciente: " + encontrarPaciente.getNomeSobrenome());
                            System.out.println("Telefone do paciente: " + encontrarPaciente.getTelefone());
                            System.out.println("Endereço do paciente: " + encontrarPaciente.getEndereco());
                            encontrar = false;
                        }else
                            System.out.println("Paciente não encontrado");
                    }
                    break;


                case 3:

                    Gerente gerencia = new Gerente("Clara Almeida", "3598527471", "1");
                    System.out.println("O dinheiro foi adicionado ao caixa!" );

                    Chefe ch1 = new Chefe("Julia Alcantara","364521452", "1");
                    break;

                case 4:
                    String nom, tel, especialide, crm;
                    sc.nextLine();

                    Medico me1 = new Medico();
                    System.out.println("Digite o nome do médico: ");
                    nom = sc.nextLine();
                    me1.getNome(nom);

                    System.out.println("Digite o telefone do médico: ");
                    tel = sc.nextLine();
                    me1.getTel(tel);

                    System.out.println("Digite a especialidade do médico: ");
                    especialide = sc.nextLine();
                    me1.getEspecialidade(especialide);

                    try {
                        if (me1.getCRM() == null) {
                            System.out.println("Digite o CRM do médico: ");
                            crm = sc.nextLine();
                            me1.getCRM();

                        }else
                            throw new CRMInvalidoException();
                    }catch (CRMInvalidoException e){
                        System.out.println("Insira o CRM novamente");
                    }


                case 5:
                    System.out.println("Voce saiu!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }


        Database database = new Database();
        database.connect();

        Paciente user = new Paciente("Antonia dos Santos", "111.111.11.00", "147582", "Rua das Palmeiras");
        Paciente user1 = new Paciente("José Faria", "1114.4556.00", "158935", "Avenida dos lagos");
        Paciente user2 = new Paciente("Marco da Silva", "4785.25474.45","789665","Avenida dos anjos");

        database.insertUser(user);
        database.insertUser(user1);
        database.insertUser(user2);

        database.reserachUser();
        System.out.println("--------Atualizando nome e sobrenome--------");
        database.updateUSer(1, "Flavia");

        database.reserachUser();

        System.out.println("--------Excluindo usuário--------");
        database.deleteUser(1);
        database.reserachUser();

    }
}