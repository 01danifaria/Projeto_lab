package br.inatel.C206.C207;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class Main {

    //criar criar, inserir, deletar, alterar
    public static void main(String[] args) throws IOException {

        ArrayList<Paciente> p = new ArrayList<Paciente>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        String nome, telefone, endereco, cpf;

        while (flag) {
            System.out.println("");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Buscar paciente");
            System.out.println("3 - Gerencia");
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
                    sc.nextLine();

                    try{ //mudar para int para comparar >= 0
                        if(p1.Convenio().equals("Convenio")) {
                            System.out.println("O paciente usou seu convenio: ");
                            sc.nextLine();
                        }
                        else
                            throw new ValorConsultaInvalidaException(p1.Convenio());
                        System.out.println("Valor da consulta: ");
                        p1.setValorConsulta();
                        sc.nextLine();
                    }catch (Exception e){
                        System.out.println(e);
                        System.out.println("!!!Continue com as informações!!!");
                    }
                    System.out.println(" ");

                    System.out.println("Digite o nome e sobrenome: ");
                    nome = sc.nextLine();
                    p1.setNomeSobrenome(nome);
                    System.out.println(" ");

                    System.out.println("Digite o telefone: ");
                    telefone = sc.nextLine();
                    p1.setTelefone(telefone);
                    System.out.println(" ");

                    System.out.println("Digite e endereço: ");
                    endereco = sc.nextLine();
                    p1.getEndereco();
                    System.out.println(" ");

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
                    String total;

                    Gerente gerencia = new Gerente("Clara Almeida", "3598527471", "1");
                    System.out.println("O total do faturamento foi: " );
                    total  = sc.nextLine();
                    gerencia.getFaturamento(total);
                    System.out.println(" ");

                    Chefe ch1 = new Chefe("Julia Alcantara","364521452", "1");
                    ch1.dinheiro();
                    break;

                case 4:
                    String Nome, tel, especialide;
                    int crm;

                    Medico me1 = new Medico();
                    System.out.println("Digite o nome do médico: ");
                    Nome = sc.nextLine();
                    me1.getNome(Nome);
                    System.out.println(" ");

                    System.out.println("Digite o telefone do médico: ");
                    tel = sc.nextLine();
                    me1.getTel(tel);
                    System.out.println(" ");

                    System.out.println("Digite a especialidade do médico: ");
                    especialide = sc.nextLine();
                    me1.getEspecialidade(especialide);
                    System.out.println(" ");

                    System.out.println("Digite o CRM do médico: ");
                    crm = Integer.parseInt(sc.nextLine());
                    me1.getCRM(crm);
                    System.out.println(" ");

                case 5:
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