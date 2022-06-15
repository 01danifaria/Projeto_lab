//Primeiro instalamos a dependecia do
package br.inatel.C206.C207;

import java.sql.*;

public abstract class Database {
    Connection connection;  //faz a conexão com o servidor do MySql
    Statement statement;    //responsável por preparar consultas "SELECT"
    ResultSet result;      //responsável por executar consultas "SECT"
    PreparedStatement pst; //prepara as querys de manipulação dinamicas CRUD

    static final String Paciente = "root";   //usuario da instancia local do servidor
    static final String password = "Macacopelado.12"; //senha do usuário da intencia local do servidor
    static final String database = "consultas";  //nome do banco de dados a ser utilizado

    //String com a URL de conexão com o servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public void connect() {  //realiza a conexão com o banco já tratando os erros
        try {
            connection = DriverManager.getConnection(url, Paciente, password);
            System.out.println("Conexão feita com sucesso: " + connection);

        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

}
