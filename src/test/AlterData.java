package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterData {
    public static void consultData() throws SQLException{
        List<Pessoa> pessoas = new ArrayList<>();

        Connection con = FabricConnection.getConnection();
        String sql = "SELECT * FROM pessoas;";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        while(result.next()) {
            int codigo = result.getInt("codigo");
            String nome = result.getString("nome");
            pessoas.add(new Pessoa(codigo,nome));
        }
        for(Pessoa p: pessoas){
            System.out.println(p.getCodigo() + "->" + p.getNome());
        }
        st.close();
        con.close();
    }

    public static void alterData(int codigo, String nome) throws SQLException{
        Connection con = FabricConnection.getConnection();
        String sql = "UPDATE pessoas SET nome = ? WHERE codigo = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setInt(2, codigo);

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Que dado você deseja alterar? Responda pelo codigo");
        consultData();
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.println("Qual o nome que deseja realocar?");
        String nome = sc.nextLine();


        alterData(codigo, nome);
        System.out.println("Feito!!");
    }
}
