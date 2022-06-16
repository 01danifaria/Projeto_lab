package br.inatel.C206.C207;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args){
        int op;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        FuncionarioDB funcionarioDB = new FuncionarioDB();            //criação de um funcionário no Banco de dados
        Funcionario funcionario = new Funcionario();                 //criação de um novo funcionário

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
                    funcionario.setNomeSobrenome(sc.nextLine());               //foi chamada a função de setar um nome do funcionario juntamente com a entrada de dados do nome do funcionario
                    System.out.println("Telefone do funcionário: ");
                    funcionario.setTelefone(sc.nextLine());                    //foi chamada a função de setar o telefone do funcionario juntamente com a entradada de dados do telefone do funcionario
                    funcionarioDB.insertFuncionario(funcionario);
                    break;

                case 2:
                    //Buscando informações no BD
                    funcionarioDB.reserachFuncionario();
                    break;

                case 3:
                    System.out.println("Entre com o nome e a identificação do funcionário para alterar: ");    //aqui foi preciso escrever o nome do funcionário e abaixo do sua identificação
                    funcionario.setNomeSobrenome(sc.nextLine());              //foi chamada a função de setar o nome do funcionário juntamente com a entrada de dados do nome do funcionário
                    funcionarioDB.updateFuncionario(sc.nextLine(),sc.nextInt());      //foi chamada a função de atualizar os funcionários juntamente com a entrada de dados do nome e id do funcionário

                    //Mostrando resultados final no BD
                    funcionarioDB.reserachFuncionario();
                    break;

                case 4:
                    System.out.println("Digite a identificação que deseja deletar: ");
                    funcionarioDB.deleteFuncionario(sc.nextInt());              //aqui foi chamada a função deletar funcionário juntamente com a entrada de dados do id, que será deletado

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