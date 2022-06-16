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
            System.out.println("2 - Buscar funcionário");
            System.out.println("3 - Atualizar funcionário");
            System.out.println("4 - Excluir funcionário");
            System.out.println("5 - Sair");
            System.out.println("Sua opção: ");
            op = sc.nextInt();
            switch (op) {

                case 1:
                    sc.nextLine();
                    System.out.println("Entre com as informações do funcionário: ");

                    System.out.println("Nome do funcionário: ");
                    funcionario.setNomeSobrenome(sc.nextLine());
                    System.out.println("Telefone do funcionário: ");
                    funcionario.setTelefone(sc.nextLine());

                    funcionarioDB.insertFuncionario(funcionario);
                    break;

                case 2:
                    //Buscando informações no BD
                    funcionarioDB.reserachFuncionario();

                    break;

                case 3:
                    System.out.println("Entre com o nome e a identificação do funcionário para alterar: ");
                    funcionario.setNomeSobrenome(sc.nextLine());

                    funcionarioDB.updateFuncionario(sc.nextLine(),sc.nextInt());
                    funcionarioDB.reserachFuncionario();
                    break;


                case 4:
                    System.out.println("Digite a identificação que deseja deletar: ");
                    funcionarioDB.deleteFuncionario(sc.nextInt());

                    //Mostrando resultados final no BD
                    funcionarioDB.reserachFuncionario();
                    break;

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