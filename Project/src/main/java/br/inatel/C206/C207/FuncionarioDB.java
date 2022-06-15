package br.inatel.C206.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDB extends Database {
    public boolean insertFuncionario(Funcionario func) {

    connect();
    String sql = "INSERT INTO Funcionario (idFuncionario, nomeSobrenome, telefone) VALUES (?, ?, ?)";

        try {
        pst = connection.prepareStatement(sql);  //relaciona o objeto responsável por preparar as querys com o objeto responsável por fazer a conexão com o servidor
        pst.setInt(1,func.getIdFunconario());
        pst.setString(2,func.getNomeSobrenome());
        pst.setString(3, func.getTelefone());            //concatena CPF na segunda ? do comando
        pst.execute();   //executa o objeto responsável por preparar querys de manipulação
        check = true;

    } catch (
    SQLException e) {
        System.out.println("Erro de operação: " + e.getMessage());
        check = false;
    } finally {
        try {
            connection.close();  //caso de erro o objeto responsável pela conexão é fechado
            pst.close();         //também fecha o objeto responsável por preparar as querys
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
        return check;
}
    //-----------------------------BUSCANDO TODOS OS REGISTROS------------------------------
    public ArrayList<Funcionario> reserachFuncionario() {
        connect(); //chamada da função que realiza a conexão com o servidor
        ArrayList<Funcionario> funcionarios = new ArrayList<>(); //varre o array n de Pacientes para fazer a busca
        String sql = "SELECT * FROM Funcionario";

        try {
            statement = connection.createStatement(); //relaciona o objeto responsável por preparar consultas "SELECT" com o objeto responsável por preparar as querys
            result = statement.executeQuery(sql);  //relaciona o objeto responsável por preparar consultas "SELECT" com o objeto responsável por executar consultas "SELECT"

            while (result.next()) { //criação de um loop com o objeto responsável por executar consultas "SELECT"
                //relacionamos o objeto responsável por executar consultas "SELECT" com as informações de Pacientes
                Funcionario funcionariotemp = new Funcionario(result.getString("nomeSobrenome"), result.getString("telefone"),result.getInt("idFuncionario"));
                //inserindo os dados do Paciente
                System.out.println("Nome = " + funcionariotemp.getNomeSobrenome());
                System.out.println("Telefone = " + funcionariotemp.getTelefone());
                System.out.println("--------------------------------------");
                funcionarios.add(funcionariotemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());

        } finally {
            try {
                connection.close(); //caso de erro o objeto responsável pela conexão é fechado
                statement.close();  //caso de erro o objeto responsável por preparar as consultas "SELECT" é fechado
                result.close();  //caso de erro o objeto responsável por executar as consultas "SELECT" é fechado

            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return funcionarios;
    }

    //-----------------------ATUALIZANDO REGISTRO--------------------------
    public boolean updateFuncionario(String nome, String telefone) {
        connect();  //chamada da função que realiza a conexão com o servidor
        String sql = "UPDATE Funcionario SET nomeSobrenome = ? WHERE telefone = ? ";

        try {
            pst = connection.prepareStatement(sql); //relaciona o objeto responsável por preparar as querys com o objeto responsável por fazer a conexão com o servidor
            pst.setString(1, nome);     //concatena nome na primeira ? do comando
            pst.setString(2, telefone);          //concatena id n na segunda ? do comando
            pst.execute();  //executa o objeto responsável por preparar querys de manipulação
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        return check;
    }

    //---------------------------EXCLINDO REGISTRO------------------------
    public boolean deleteFuncionario(String telefone){
        connect(); //chamada da função que realiza a conexão com o servidor
        String sql = "DELETE FROM Funcionario WHERE telefone = ?";

        try {
            pst = connection.prepareStatement(sql); //relaciona o objeto responsável por preparar as querys com o objeto responsável por fazer a conexão com o servidor
            pst.setString(1, telefone);  //concatena nome na primeira ? do comando
            pst.execute(); //executa o objeto responsável por preparar querys de manipulação
            check = true;

        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try{
                connection.close(); //caso de erro o objeto responsável pela conexão é fechado
                pst.close();  //também fecha o objeto responsável por preparar as querys

            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
