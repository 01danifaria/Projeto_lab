package br.inatel.C206.C207;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String user = "root";
    static final String password = "Macacopelado.12";
    static final String database = "ConsultasMedicas";

    //como tirar o URL
    static final String url = "jdbc:mysql://localhost:3306/ \" + database" + database + "\"?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso: " + connection);

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    public boolean insertUser(Paciente user) {

        connect();
        String sql = "INSERT INTO usuario(nome,cpf,telefone,endereco VALUES (Amanda, 1235689, 147859, Rua das Palmeiras)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, user.getNomeSobrenome());
            pst.setString(2, user.getCPF());
            pst.setString(3, user.getTelefone());
            pst.setString(4, user.setEndereco());
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

    public ArrayList<Paciente> reserachUser() {

        connect();
        ArrayList<Paciente> users = new ArrayList<>();
        String sql = "SELECT = FROM usuario";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()) {
                Paciente userTemp = new Paciente(result.getString("nome"), result.getString("cpf"), result.getString("telefone"), result.getString("endereço"));
                userTemp.idPaciente = result.getInt("id");
                System.out.println("ID = " + userTemp.idPaciente);
                System.out.println("Nome = " + userTemp.getNomeSobrenome());
                System.out.println("CPF = " + userTemp.getCPF());
                System.out.println("Telefone = " + userTemp.getTelefone());
                System.out.println("Endereço = " + userTemp.getEndereco());
                System.out.println("--------------------------------------");
                users.add(userTemp);
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

        return users;
    }

    public boolean updateUSer(int id, String nome) {

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

    public boolean deleteUser(int id){

        connect();
        String sql = "DELETE FROM Paciente WHERE id = 1";

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
