package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricConnection {

    public static Connection getConnection() {
        // trocando uma excessão checada por uma não checada
        try {
            Properties props = getProperties();

            final String url = props.getProperty("banco.url");
            final String user = props.getProperty("banco.user");
            final String password = props.getProperty("banco.password");

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Properties getProperties()throws IOException {
        Properties prop = new Properties();
        String path = "test/conxao.properties";

        prop.load(FabricConnection.class.getResourceAsStream(path));
        return prop;
    }
}
