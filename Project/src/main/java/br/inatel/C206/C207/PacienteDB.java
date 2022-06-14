package br.inatel.C206.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDB extends Database{

    //----------------------INSERINDO REGISTROS-----------------------------------------------
    public boolean insertPaciente(Paciente paciente) {

        connect(); //chamada da função que realiza a conexão com o servidor
        String sql = "INSERT INTO usuario(nome,cpf,telefone,endereco VALUES (?, ?, ?, ?)";

        try {
            pst = connection.prepareStatement(sql);  //relaciona o objeto responsável por preparar as querys com o objeto responsável por fazer a conexão com o servidor
            pst.setString(1, paciente.getNomeSobrenome());  //concatena nome na primeira ? do comando
            pst.setString(2, paciente.getcpf());            //concatena CPF na segunda ? do comando
            pst.setString(3, paciente.getTelefone());       //concatena telefone na terceira ? do comando
            pst.setString(4, paciente.getEndereco());      //concatena endereço na quarta ? do comando
            pst.execute();   //executa o objeto responsável por preparar querys de manipulação
            check = true;

        } catch (SQLException e) {
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
    public ArrayList<Paciente> reserachPaciente() {
        connect(); //chamada da função que realiza a conexão com o servidor
        ArrayList<Paciente> pacientes = new ArrayList<>(); //varre o array n de Pacientes para fazer a busca
        String sql = "SELECT * FROM usuario";

        try {
            statement = connection.createStatement(); //relaciona o objeto responsável por preparar consultas "SELECT" com o objeto responsável por preparar as querys
            result = statement.executeQuery(sql);  //relaciona o objeto responsável por preparar consultas "SELECT" com o objeto responsável por executar consultas "SELECT"

            while (result.next()) { //criação de um loop com o objeto responsável por executar consultas "SELECT"
               //relacionamos o objeto responsável por executar consultas "SELECT" com as informações de Pacientes
                Paciente pacienteTemp = new Paciente(result.getString("nome"), result.getString("cpf"), result.getString("telefone"), result.getString("endereço"), result.getString("valor consulta"));
                pacienteTemp.idPaciente = result.getInt("id");
                if(pacienteTemp.idPaciente > 0) {
                    System.out.println("ID = " + pacienteTemp.idPaciente);
                    System.out.println("-------------------------");
                }
                //inserindo os dados do Paciente
                System.out.println("Nome = " + pacienteTemp.getNomeSobrenome());
                System.out.println("CPF = " + pacienteTemp.getcpf());
                System.out.println("Telefone = " + pacienteTemp.getTelefone());
                System.out.println("Endereço = " + pacienteTemp.getEndereco());
                System.out.println("Valor consulta = " + pacienteTemp.getValorConsulta());
                System.out.println("--------------------------------------");
                pacientes.add(pacienteTemp);
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

        return pacientes;
    }

    //-----------------------ATUALIZANDO REGISTRO--------------------------
    public boolean updatePaciente(int id, String nome) {
        connect();  //chamada da função que realiza a conexão com o servidor
        String sql = "UPDATE usuario SET nome ? WHERE id = ? ";

        try {
            pst = connection.prepareStatement(sql); //relaciona o objeto responsável por preparar as querys com o objeto responsável por fazer a conexão com o servidor
            pst.setString(1, nome);     //concatena nome na primeira ? do comando
            pst.setInt(2, id);          //concatena id n na segunda ? do comando
            pst.execute();  //executa o objeto responsável por preparar querys de manipulação
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        return check;
    }

    //---------------------------EXCLINDO REGISTRO------------------------
    public boolean deletePaciente(int id){
        connect(); //chamada da função que realiza a conexão com o servidor
        String sql = "DELETE FROM Paciente WHERE id = ?";

        try {
            pst = connection.prepareStatement(sql); //relaciona o objeto responsável por preparar as querys com o objeto responsável por fazer a conexão com o servidor
            pst.setInt(1, id);  //concatena nome na primeira ? do comando
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
