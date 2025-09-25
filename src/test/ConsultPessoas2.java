package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultPessoas2 {
    public static void main(String[] args) throws SQLException {
        // lista de objetos
        List<Pessoa> pessoas = new ArrayList<>();

        // Criando a conexão
        String url = "jdbc:mysql://localhost/teste_java?verifyServerCertificate=false&useSSL=true";
        String user = "root";
        String password = "tBw$FDHuQgZF8E";
        Connection con = DriverManager.getConnection(url,user,password);

        // Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("O que você quer procurar? ");
        String param = sc.nextLine();

        // Comando SQL
        String sql = "SELECT * FROM pessoas WHERE nome LIKE (?);";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1,"%" + param + "%");
        // Executando a query
        ResultSet result = ps.executeQuery();

        // enquanto tiver registros na query ele instancia novos objetos.
        while(result.next()){
            int codigo = result.getInt("codigo");
            String nome = result.getString("nome");
            pessoas.add(new Pessoa(codigo,nome));
        }

        for(Pessoa p:pessoas){
            System.out.println(p.getCodigo() + " => " + p.getNome());
        }
        con.close();
        sc.close();
        ps.close();
    }
}
