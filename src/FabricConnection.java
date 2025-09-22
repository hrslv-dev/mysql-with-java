import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
    private static Properties getProperties()throws IOException {
        Properties prop = new Properties();
        String path = "conxao.properties";

        prop.load(FabricConnection.class.getResourceAsStream(path));

    }
}
