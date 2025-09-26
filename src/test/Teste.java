package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teste{
    public static void main(String[] args){
        DAO dao = new DAO();

        String command = "SELECT * FROM pessoas WHERE codigo<?;";
        
        List<Pessoa> pessoas = new ArrayList<>();

        try {
            ResultSet rs = dao.query(command, 7);
            while(rs.next()){
                String nome = rs.getString("nome");
                int codigo = rs.getInt("codigo");
                pessoas.add(new Pessoa(codigo,nome));
            }
            for(Pessoa p: pessoas){
                System.out.println(p.getNome() + "->" + p.getCodigo());
            }
            dao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
