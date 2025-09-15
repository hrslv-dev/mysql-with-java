import java.sql.Connection; // Pacote com uso de banco de dados MySQL é na java.sql
import java.sql.DriverManager;
import java.sql.SQLException;

// todos os imports são interfaces.
public class TesteConnection {      // FIXME Qual a diferença entre um try catch e assinar o método com a excessão?
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";  // String de conexão
        final String user = "root";
        final String password = "tBw$FDHuQgZF8E";

        // "Interprete" entre o java o SQL -> classe que traduz os comandos java para
        Connection connection = DriverManager.
                getConnection(url,user,password);

        System.out.println("Conexão efetuada com sucesso!");
        connection.close();
    };
}
