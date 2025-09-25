package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingaDataBase {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "tBw$FDHuQgZF8E";

        Connection con = DriverManager.getConnection(url,user,password);

        System.out.println("Conexão efetuada !");

        Statement stmt = con.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS teste_java");
        System.out.println("Banco foi criado com sucesso !");
        con.close();
    }
}
