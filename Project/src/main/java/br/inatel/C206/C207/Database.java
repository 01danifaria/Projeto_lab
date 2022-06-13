package br.inatel.C206.C207;

import java.sql.*;

public abstract class Database {
    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String Paciente = "root";
    static final String password = "Macacopelado.12";
    static final String database = "mydb";

    //como tirar o URL
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, Paciente, password);
            System.out.println("Conexão feita com sucesso: " + connection);

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

}
