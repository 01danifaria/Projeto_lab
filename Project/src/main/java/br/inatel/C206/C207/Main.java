package br.inatel.C206.C207;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        int op;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Paciente paciente = new Paciente();
        PacienteDB pacienteDB = new PacienteDB();
        ArrayList<Paciente> p = new ArrayList<Paciente>();
        FuncionarioDB funcionarioDB = new FuncionarioDB();
        Funcionario funcionario = new Funcionario();
        String nome, nomef;
        String telefone, telf;
        String endereco;
        String cpf;
        int valorConsulta, idF, idP, idFK;


        while (flag) {
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Cadastrar paciente");
            System.out.println("3 - Buscar funcionário");
            System.out.println("4 - Atualizar funcionário");
            System.out.println("5 - Excluir funcionário");
            System.out.println("6 - Sair");
            System.out.println("Sua opção: ");
            op = sc.nextInt();
            switch (op) {

                case 1:
                    sc.nextLine();
                    System.out.println("Entre com as informações do funcionário: ");

                    System.out.println("Nome do funcionário: ");
                    nomef = sc.nextLine();
                    funcionario.setNomeSobrenome(nomef);

                    System.out.println("Telefone do funcionário: ");
                    telf = sc.nextLine();
                    funcionario.setTelefone(telf);

                    funcionarioDB.insertFuncionario(funcionario);
                    break;

                case 2:
                    Paciente p1 = new Paciente();
                    System.out.println("Entre com as informações: ");
                    System.out.println("Digite o valor da consulta: ");
                    valorConsulta = sc.nextInt();
                    p1.setValorConsulta(valorConsulta);

                    sc.nextLine();

                    System.out.println("Digite o nome do paciente: ");
                    nome = sc.nextLine();
                    p1.setNomeSobrenome(nome);

                    System.out.println("Digite o CPF do paciente: ");
                    cpf = sc.nextLine();
                    p1.setcpf(cpf);
                    System.out.println("Digite o telefone do paciente: ");
                    telefone = sc.nextLine();
                    p1.setTelefone(telefone);
                    System.out.println("Digite o endereço do paciente: ");
                    endereco = sc.nextLine();
                    p1.setEndereco(endereco);

                    p.add(p1);//adiciona o paciente atual à nossa lista de pacientes
                    System.out.println("Paciente cadastrado! ");
                    break;


                case 3:
                    //Buscando informações no BD
                    funcionarioDB.reserachFuncionario();

                    break;

                case 4:
                    System.out.println("--------Atualizando nome e sobrenome--------");
                    funcionarioDB.updateFuncionario("Carolina", "8526");

                    //Mostrando resultados final no BD
                    funcionarioDB.reserachFuncionario();
                    break;


                case 5:
                    System.out.println("--------Excluindo usuário--------");
                    funcionarioDB.deleteFuncionario("6325");

                    //Mostrando resultados final no BD
                    funcionarioDB.reserachFuncionario();
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