package br.inatel.C206.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDB extends Database{

    //----------------------INSERINDO REGISTROS-----------------------------------------------
    public boolean insertPaciente(Paciente paciente) {

        connect();
        String sql = "INSERT INTO usuario(nome,cpf,telefone,endereco VALUES (?, ?, ?, ?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, paciente.getNomeSobrenome());
            pst.setString(2, paciente.getCPF());
            pst.setString(3, paciente.getTelefone());
            pst.setString(4, paciente.getEndereco());
            pst.execute();
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
//-----------------------------BUSCANDO TODOS OS REGISTROS------------------------------
    public ArrayList<Paciente> reserachPaciente() {
        connect();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                Paciente pacienteTemp = new Paciente(result.getString("nome"), result.getString("cpf"), result.getString("telefone"), result.getString("endereço"), result.getInt("valor consulta"));
                pacienteTemp.idPaciente = result.getInt("id");
                if(pacienteTemp.idPaciente > 0) {
                    System.out.println("ID = " + pacienteTemp.idPaciente);
                    System.out.println("-------------------------");
                }

                System.out.println("Nome = " + pacienteTemp.getNomeSobrenome());
                System.out.println("CPF = " + pacienteTemp.getCPF());
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
                connection.close();
                statement.close();
                result.close();

            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }

        }

        return pacientes;
    }

    //-----------------------ATUALIZANDO REGISTRO--------------------------
    public boolean updatePaciente(int id, String nome) {
        connect();
        String sql = "UPDATE usuario SET nome João WHERE id = 1 ";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        return check;
    }

    //---------------------------EXCLINDO REGISTRO------------------------
    public boolean deletePaciente(int id){
        connect();
        String sql = "DELETE FROM Paciente WHERE id = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;

        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try{
                connection.close();
                pst.close();

            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
