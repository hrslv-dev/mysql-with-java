import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablePersons {
    public static void main(String[] args) throws SQLException {
        Connection con = FabricConnection.getConnection();
        String sql = """
                CREATE TABLE pessoas (
                    codigo INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(80) NOT NULL
                );
                """;
        Statement st = con.createStatement();
        st.execute(sql);

        System.out.println("tabela criada com sucesso!");
        con.close();
    }
}
