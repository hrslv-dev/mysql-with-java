import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultPessoas1 {
    public static void main(String[] args) throws SQLException {
        Connection con = FabricConnection.getConnection();
        String sql = "SELECT * FROM pessoas";

        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(sql);

        List<Pessoa> pessoas = new ArrayList<>();
                                    // result.next() -> retorna um valor boolean que diz se tem um proximo registro
                                    // Quando o metodo der false ele sai do loop
        while(result.next()) {
            int codigo = result.getInt("codigo");
            String nome = result.getString("nome");
            pessoas.add(new Pessoa(codigo,nome));
        }

        for(Pessoa p: pessoas){ // percorre as pessoas
            System.out.println(p.getCodigo() + " ==> " + p.getNome());
        }

        st.close();
        con.close();
    }
}
