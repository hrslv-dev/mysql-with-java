import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricConnection {

    public static Connection getConnection() {
        // trocando uma excessão checada por uma não checada
        try {
            final String url = "jdbc:mysql://localhost/teste_java?verifyServerCertificate=false&useSSL=true";
            final String user = "root";
            final String password = "tBw$FDHuQgZF8E";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
